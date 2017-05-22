package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;
import java.io.FileFilter;

import org.com.owl.utils.deleteRDirectory.file.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.file.FileProcessor;

public final class DefaultDirectoryProcessor
    implements
    DirectoryProcessable {

    @Override
    public final boolean processDirectory(
        final DirectoryFile directory,
        final FileFilter fileFilter,
        final FileProcessor fileProcessor) {
        File[] files = directory.listFiles(fileFilter);
        if (files == null) {
            return Boolean.TRUE;
        } else {
            boolean sucess = Boolean.TRUE;
            for (File eachFile : files) {
                if (fileProcessor.process(eachFile) && sucess) {
                    sucess = Boolean.TRUE;
                } else {
                    sucess = Boolean.FALSE;
                }
            }
            return sucess;
        }
    }
}
