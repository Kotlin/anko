/*
 * Copyright 2014 JetBrains s.r.o.
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

package org.jetbrains.android.dsl.tests;

import org.jetbrains.android.dsl.GeneratorConfiguration;
import org.jetbrains.android.dsl.KoanFile;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TestGeneratorConfiguration extends GeneratorConfiguration {
    public TestGeneratorConfiguration() throws IOException {
        tmpFiles.put(KoanFile.VIEWS, File.createTempFile("Views", ".kt"));
        tmpFiles.put(KoanFile.LAYOUTS, File.createTempFile("Layouts", ".kt"));
        tmpFiles.put(KoanFile.PROPERTIES, File.createTempFile("Properties", ".kt"));
        tmpFiles.put(KoanFile.LISTENERS, File.createTempFile("Listeners", ".kt"));
        tmpFiles.put(KoanFile.HELPERS, File.createTempFile("Helpers", ".kt"));
        tmpFiles.put(KoanFile.SUPPORT, File.createTempFile("Support", ".kt"));
        tmpFiles.put(KoanFile.CUSTOM, File.createTempFile("Custom", ".kt"));
        tmpFiles.put(KoanFile.ASYNC, File.createTempFile("Async", ".kt"));
        tmpFiles.put(KoanFile.CONTEXT_UTILS, File.createTempFile("ContextUtils", ".kt"));
        tmpFiles.put(KoanFile.DIALOGS, File.createTempFile("Dialogs", ".kt"));
        tmpFiles.put(KoanFile.SERVICES, File.createTempFile("Services", ".kt"));
        tmpFiles.put(KoanFile.INTERNALS, File.createTempFile("Internals", ".kt"));
        tmpFiles.put(KoanFile.DATABASE, File.createTempFile("Database", ".kt"));
    }

    public final HashMap<KoanFile, File> tmpFiles = new HashMap<>();

    @NotNull
    @Override
    public File getOutputFile(KoanFile subsystem) {
        return tmpFiles.get(subsystem);
    }
}
