package org.com.owl.utils.deleteRDirectory.beans;

import org.com.owl.utils.deleteRDirectory.file.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.file.FileProcessor;

public interface DirectoryFilterProcessor {

    boolean processDirectory(
        DirectoryFile directory,
        FileProcessor fileProcessor);
}
