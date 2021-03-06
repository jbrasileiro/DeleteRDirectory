package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;
import java.io.FileFilter;

import org.com.commons.io.file.DirectoryFile;
import org.com.commons.io.file.DirectoryFilter;
import org.com.commons.io.file.DirectoryProcessable;
import org.com.commons.io.file.FileDeleter;
import org.com.commons.io.file.FileProcessor;

public final class RecursiveDirectoryProcessor {

    private final DirectoryProcessable processor;
    private final RecursiveDirectoryDeleter deleter;

    public RecursiveDirectoryProcessor(
        final DirectoryProcessable processor,
        final RecursiveDirectoryDeleter deleter) {
        super();
        this.processor = processor;
        this.deleter = deleter;
    }

    public boolean process(
        final DirectoryFile directory,
        final FileDeleter fileDeleter,
        final String[] directoriesName) {
        FileFilter fileFilter = fileFilter();
        return processor.processDirectory(directory, fileFilter,
            fileProcessor(directoriesName, fileDeleter));
    }

    private FileFilter fileFilter() {
        return new DirectoryFilter();
    }

    private FileProcessor fileProcessor(
        final String[] directoriesName,
        final FileDeleter fileDeleter) {
        return new FileProcessor() {

            @Override
            public boolean process(
                final File file) {
                return deleter.delete(file, directoriesName, fileDeleter);
            }
        };
    }
}
