package com.jetbrains.android.dsl.tests;

import com.jetbrains.android.dsl.GeneratorProps;
import com.jetbrains.android.dsl.Subsystem;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TestGeneratorProps extends GeneratorProps {
    public TestGeneratorProps() throws IOException {
        tmpFiles.put(Subsystem.VIEWS, File.createTempFile("views", ".kt"));
        tmpFiles.put(Subsystem.LAYOUTS, File.createTempFile("layouts", ".kt"));
        tmpFiles.put(Subsystem.PROPERTIES, File.createTempFile("properties", ".kt"));
        tmpFiles.put(Subsystem.LISTENERS, File.createTempFile("listeners", ".kt"));
        tmpFiles.put(Subsystem.HELPER, File.createTempFile("helper", ".kt"));
        tmpFiles.put(Subsystem.SUPPORT, File.createTempFile("support", ".kt"));
    }

    public final HashMap<Subsystem, File> tmpFiles = new HashMap<>();

    @NotNull
    @Override
    public File getOutputFile(Subsystem subsystem) {
        return tmpFiles.get(subsystem);
    }
}
