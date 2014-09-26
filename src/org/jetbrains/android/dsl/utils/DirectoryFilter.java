package org.jetbrains.android.dsl.utils;

import java.io.File;
import java.io.FileFilter;

public final class DirectoryFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory() && !pathname.isHidden() && pathname.getName().matches("^[0-9]+s?$");
    }
}
