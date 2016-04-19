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

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.progress.util.ProgressIndicatorBase
import com.intellij.util.ui.UIUtil
import org.jetbrains.android.uipreview.AndroidLayoutPreviewToolWindowForm

import java.awt.event.ActionListener

class AnkoPreviewProgressIndicator(
        private val myForm: AndroidLayoutPreviewToolWindowForm,
        private val myDelay: Int
) : ProgressIndicatorBase() {
    private val lock = Object()

    override fun start() {
        super.start()
        UIUtil.invokeLaterIfNeeded(Runnable {
            val timer = UIUtil.createNamedTimer("Android rendering progress timer", myDelay, ActionListener {
                synchronized (lock) {
                    if (isRunning) {
                        myForm.previewPanel.registerIndicator(this@AnkoPreviewProgressIndicator)
                    }
                }
            })
            timer.isRepeats = false
            timer.start()
        })
    }

    override fun stop() {
        synchronized (lock) {
            super.stop()
            ApplicationManager.getApplication().invokeLater {
                myForm.previewPanel.unregisterIndicator(this@AnkoPreviewProgressIndicator)
            }
        }
    }
}
