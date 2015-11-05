/*
 * Copyright 2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.android.dslpreview

import com.google.common.io.Files
import com.google.common.io.Resources
import com.google.gson.Gson
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import org.zeromq.ZMQ
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.util.jar.JarFile
import java.util.zip.ZipEntry

class DslWorker(private val myListener: DslWorker.Listener) {
    private val GSON = Gson()
    private val START_MARKER = "" + (5.toChar()) + (7.toChar()) + (5.toChar())
    private val END_MARKER = START_MARKER + START_MARKER

    @Volatile
    private var myAlive = false

    @Volatile
    private var myPort = 0

    @Volatile
    private var myLastProcess: Process? = null

    private val ROBOWRAPPER_LOCK = Object()
    private val DOWNLOAD_LOCK = Object()

    private fun downloadRobowrapperDependencies(cmd: RobowrapperContext, deps: List<Dependency>) {
        val downloadTask = DependencyDownloadTask(cmd, deps)
        ProgressManager.getInstance().run(downloadTask)
    }

    private fun checkRobowrapperDependencies(cmd: RobowrapperContext): Boolean {
        val tempDirectory = File(RobowrapperDependencies.DEPENDENCIES_DIRECTORY, "tmp/")
        if (!tempDirectory.exists()) {
            tempDirectory.mkdirs()
        }

        val downloaded = RobowrapperDependencies.DEPENDENCIES.all { it.file.exists() }
        if (!downloaded) {
            downloadRobowrapperDependencies(cmd, RobowrapperDependencies.DEPENDENCIES)
        }
        return downloaded
    }

    fun finishWorkingProcess() {
        if (myLastProcess != null) {
            myLastProcess!!.destroy()
        }
    }

    fun exec(cmd: RobowrapperContext) {
        if (!checkRobowrapperDependencies(cmd)) {
            return
        }

        if (myAlive && myPort > 0) {
            execAlive(cmd)
            return
        }

        val robowrapperDirectory = RobowrapperDependencies.DEPENDENCIES_DIRECTORY.absolutePath
        if (robowrapperDirectory.isEmpty()) {
            myListener.onXmlError(ErrorKind.INVALID_ROBOWRAPPER_DIRECTORY, "Robowrapper directory is empty.", false)
            return
        }

        ProgressManager.getInstance().run(RobowrapperExecTask(cmd))
    }

    private fun execAlive(cmd: RobowrapperContext) {
        if (myPort <= 0) {
            myAlive = false
            exec(cmd)
            return
        }

        ProgressManager.getInstance().run(RobowrapperExecAliveTask(cmd))
    }

    private fun processData(cmd: RobowrapperContext, outputText: String, alive: Boolean) {
        val processor = DataProcessor(cmd, outputText, alive)
        ApplicationManager.getApplication().invokeLater(processor)
    }

    interface Listener {
        fun onXmlError(kind: ErrorKind, description: String, alive: Boolean)
        fun onXmlReceived(cmd: RobowrapperContext, xml: String)
    }

    enum class ErrorKind {
        INVALID_ROBOWRAPPER_DIRECTORY,
        UNKNOWN,
        UNKNOWN_ANDROID_VERSION
    }

    private inner class DataProcessor(val cmd: RobowrapperContext, private val outputText: String, private val alive: Boolean) : Runnable {

        override fun run() {
            val startMarker = outputText.indexOf(START_MARKER)
            val endMarker = outputText.indexOf(END_MARKER, startMarker + START_MARKER.length)

            if (startMarker < 0 || endMarker < 0 || endMarker <= startMarker) {
                myAlive = false
                myListener.onXmlError(ErrorKind.UNKNOWN, "Unable to find message markers.", false)
                return
            }

            val rawData = outputText.substring(startMarker + START_MARKER.length, endMarker)
            val pack = GSON.fromJson<Pack>(rawData, Pack::class.java)

            myPort = pack.port
            myAlive = pack.alive

            if (pack.error_code != 0 || pack.xml.isEmpty()) {
                if (!alive) {
                    myListener.onXmlError(ErrorKind.UNKNOWN, "Unknown error ${pack.error_code}: ${pack.error}", myAlive)
                }
                else exec(cmd)
            }
            else {
                debug(pack.xml)
                myListener.onXmlReceived(cmd, pack.xml)
            }
        }
    }

    private inner class RobowrapperExecTask(val ctx: RobowrapperContext) :
            Task.Backgroundable(ctx.androidFacet.module.project, "Executing DSL", false) {

        override fun run(progressIndicator: ProgressIndicator) {
            progressIndicator.isIndeterminate = true

            val pluginJarFile = PathManager.getJarPathForClass(javaClass)!!
            val pluginDirectory = File(pluginJarFile).getParent()
            val policyFile = File(RobowrapperDependencies.DEPENDENCIES_DIRECTORY, "custom.policy")

            synchronized (ROBOWRAPPER_LOCK) {
                try {
                    if (!policyFile.exists()) {
                        var robowrapperJar: JarFile? = null
                        try {
                            robowrapperJar = JarFile(File(pluginDirectory, "../robowrapper/robowrapper.jar"))
                            robowrapperJar
                                    .getInputStream(ZipEntry("custom.policy"))
                                    .copyTo(FileOutputStream(policyFile))
                        } finally {
                            robowrapperJar?.close()
                        }
                    }

                    val builder = ProcessBuilder(ctx.makeArguments())
                    debug("Robowrapper command-line: " + builder.command().joinToString(" "))

                    val process = builder.start()
                    myLastProcess = process
                    val text = process.inputStream.reader("UTF-8").useLines {
                        it.takeWhile { !it.contains(END_MARKER) }.joinToString("\n", postfix = END_MARKER)
                    }

                    processData(ctx, text, false)
                } catch (e: Exception) {
                    ctx.removeManifest()
                    e.printStackTrace()
                }
            }
        }
    }

    private inner class RobowrapperExecAliveTask(private val ctx: RobowrapperContext) :
            Task.Backgroundable(ctx.androidFacet.module.project, "Executing DSL", false) {
        override fun run(progressIndicator: ProgressIndicator) {
            progressIndicator.isIndeterminate = true
            synchronized (ROBOWRAPPER_LOCK) {
                try {
                    val context = ZMQ.context(1)
                    val requester = context.socket(ZMQ.REQ)
                    requester.sendTimeOut = 1000
                    requester.receiveTimeOut = 20000
                    requester.connect("tcp://localhost:" + myPort)

                    requester.send(ctx.activityClassName.toByteArray("UTF-8"), 0)
                    val reply = requester.recv(0)

                    val replyString = reply.toString("UTF-8")
                    debug(replyString)
                    processData(ctx, replyString, true)

                    requester.close()
                    context.term()
                } catch (e: Exception) {
                    e.printStackTrace()
                    ctx.removeManifest()
                    myLastProcess?.destroy()

                    // If alive task failed, launch non-alive version
                    ApplicationManager.getApplication().invokeLater {
                        myAlive = false
                        exec(ctx)
                    }
                }

            }
        }
    }

    private inner class DependencyDownloadTask(
            private val ctx: RobowrapperContext,
            private val dependencies: List<Dependency>
    ) : Task.Backgroundable(ctx.androidFacet.module.project, "Downloading dependencies", false) {

        override fun run(progressIndicator: ProgressIndicator) {
            progressIndicator.isIndeterminate = true

            fun reportDownloadError(url: String) {
                ApplicationManager.getApplication().invokeLater{
                    myListener.onXmlError(ErrorKind.UNKNOWN, "Failed to download $url", false)
                }
            }

            val result = synchronized(DOWNLOAD_LOCK) {
                dependencies.all { dependency ->
                    try {
                        if (!dependency.file.exists()) {
                            val url = URL(dependency.downloadUrl)
                            Resources.asByteSource(url).copyTo(Files.asByteSink(dependency.file))
                        }
                        true
                    } catch (e: Exception) {
                        e.printStackTrace()
                        if (dependency.file.exists()) {
                            dependency.file.delete()
                        }
                        reportDownloadError(dependency.downloadUrl)
                        false
                    }
                }
            }

            if (result) {
                ApplicationManager.getApplication().invokeLater { exec(ctx) }
            }
        }
    }

    private fun debug(s: String) {
        if (DEBUG) {
            println(s)
            Logger.getInstance(javaClass).debug(s)
        }
    }

}

