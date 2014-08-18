package com.jetbrains.android.dsl.tests;

import org.jetbrains.annotations.NotNull;
import com.jetbrains.android.dsl.GeneratorProps;
import com.jetbrains.android.dsl.Subsystem;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TestGeneratorProps extends GeneratorProps {
    public TestGeneratorProps() throws IOException {
        tmpFiles.put(Subsystem.VIEWS, File.createTempFile("views", ".kt"));
        tmpFiles.put(Subsystem.LAYOUTS , File.createTempFile("layouts", ".kt"));
        tmpFiles.put(Subsystem.PROPERTIES, File.createTempFile("properties", ".kt"));
        tmpFiles.put(Subsystem.LISTENERS, File.createTempFile("listeners", ".kt"));
        tmpFiles.put(Subsystem.HELPER, File.createTempFile("helper", ".kt"));
    }

    public final HashMap<Subsystem, File> tmpFiles = new HashMap<>();

	private File getFile(String name, String ext) {
		return new File("tmp/"+name+ext);
	}

	@NotNull
    @Override
    public File getOutputFile(Subsystem subsystem) {
        return tmpFiles.get(subsystem);
    }
}
