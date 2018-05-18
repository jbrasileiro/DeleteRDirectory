package org.com.commons.io.file;

public interface DirectoryFilterProcessor {

    boolean processDirectory(
        DirectoryFile directory,
        FileProcessor fileProcessor);
}
