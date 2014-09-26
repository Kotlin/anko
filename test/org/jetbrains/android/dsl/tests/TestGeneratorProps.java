package org.jetbrains.android.dsl.tests;

import org.jetbrains.android.dsl.GeneratorProps;
import org.jetbrains.android.dsl.Subsystem;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TestGeneratorProps extends GeneratorProps {
    public TestGeneratorProps() throws IOException {
        tmpFiles.put(Subsystem.VIEWS, File.createTempFile("Views", ".kt"));
        tmpFiles.put(Subsystem.LAYOUTS, File.createTempFile("Layouts", ".kt"));
        tmpFiles.put(Subsystem.PROPERTIES, File.createTempFile("Properties", ".kt"));
        tmpFiles.put(Subsystem.LISTENERS, File.createTempFile("Listeners", ".kt"));
        tmpFiles.put(Subsystem.HELPERS, File.createTempFile("Helpers", ".kt"));
        tmpFiles.put(Subsystem.SUPPORT, File.createTempFile("Support", ".kt"));
        tmpFiles.put(Subsystem.CUSTOM, File.createTempFile("Custom", ".kt"));
        tmpFiles.put(Subsystem.ASYNC, File.createTempFile("Async", ".kt"));
        tmpFiles.put(Subsystem.CONTEXT_UTILS, File.createTempFile("ContextUtils", ".kt"));
        tmpFiles.put(Subsystem.DIALOGS, File.createTempFile("Dialogs", ".kt"));
    }

    public final HashMap<Subsystem, File> tmpFiles = new HashMap<>();

    @NotNull
    @Override
    public File getOutputFile(Subsystem subsystem) {
        return tmpFiles.get(subsystem);
    }
}
