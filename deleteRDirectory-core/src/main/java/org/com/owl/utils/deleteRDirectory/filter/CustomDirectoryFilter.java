package org.com.owl.utils.deleteRDirectory.filter;

import java.io.File;
import java.io.FileFilter;

public final class CustomDirectoryFilter
    implements
    FileFilter {

    private final DirectoryFilter directoryFilter;
    private final String[] names;

    public CustomDirectoryFilter(
        final DirectoryFilter directoryFilter,
        final String[] names) {
        super();
        this.directoryFilter = directoryFilter;
        this.names = names;
    }

    @Override
    public boolean accept(
        final File file) {
        return directoryFilter.accept(file) && contains(file.getName());
    }

    private boolean contains(
        final String name) {
        for (String vValue : names) {
            if (vValue.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
