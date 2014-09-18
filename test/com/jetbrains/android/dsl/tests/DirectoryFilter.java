package com.jetbrains.android.dsl.tests;

import java.io.File;
import java.io.FileFilter;

public final class DirectoryFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory() && !pathname.isHidden();
    }
}
