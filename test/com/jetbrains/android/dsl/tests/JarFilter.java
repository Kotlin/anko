package com.jetbrains.android.dsl.tests;

import java.io.File;
import java.io.FileFilter;

public final class JarFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isFile() && pathname.getName().toLowerCase().endsWith(".jar");
    }
}
