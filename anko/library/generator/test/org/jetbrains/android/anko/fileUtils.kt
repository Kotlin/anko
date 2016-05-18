/*
 * Copyright 2016 JetBrains s.r.o.
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

package org.jetbrains.android.anko

import java.io.File

fun createTempTestFile(name: String, extension: String): File {
    val dir = File("workdir/temp")
    if (!dir.exists()) dir.mkdirs()

    val file = File(dir, "$name$extension")
    if (file.exists()) file.delete()
    file.createNewFile()

    return file
}