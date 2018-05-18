package org.com.commons.io.file;

import java.io.FileFilter;

public interface DirectoryProcessable {

    boolean processDirectory(
        DirectoryFile directory,
        FileFilter fileFilter,
        FileProcessor fileProcessor);
}
