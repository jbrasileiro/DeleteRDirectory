package org.com.owl.utils.deleteRDirectory.beans;

import java.io.FileFilter;

import org.com.owl.utils.deleteRDirectory.file.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.file.FileDeleter;
import org.com.owl.utils.deleteRDirectory.file.FileProcessor;
import org.com.owl.utils.deleteRDirectory.filter.DirectoryFilter;

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
        return file -> deleter.delete(file, directoriesName, fileDeleter);
    }
}
