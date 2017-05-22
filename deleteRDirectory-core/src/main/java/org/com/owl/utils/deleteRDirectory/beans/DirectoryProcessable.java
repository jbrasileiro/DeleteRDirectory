package org.com.owl.utils.deleteRDirectory.beans;

import java.io.FileFilter;

import org.com.owl.utils.deleteRDirectory.file.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.file.FileProcessor;

public interface DirectoryProcessable {

    boolean processDirectory(
        DirectoryFile directory,
        FileFilter fileFilter,
        FileProcessor fileProcessor);
}
