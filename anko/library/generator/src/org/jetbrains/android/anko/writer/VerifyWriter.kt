package org.jetbrains.android.anko.writer

import org.jetbrains.android.anko.render.RenderFacade
import org.jetbrains.anko.test.assertEqualsToFile
import java.io.File

class VerifyWriter(renderFacade: RenderFacade) : AbstractWriter(renderFacade) {
    override fun write(file: File, @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE") actualText: String) {
        if (!file.exists()) {
            file.writeText(actualText)
            println("E $file: file did not exist")
            throw AssertionError("File did not exist: $file")
        }

        try {
            assertEqualsToFile(file.name, file, actualText)
        } catch (e: Throwable) {
            println("E $file: File was changed")
            throw e
        }

        println("OK $file")
    }
}