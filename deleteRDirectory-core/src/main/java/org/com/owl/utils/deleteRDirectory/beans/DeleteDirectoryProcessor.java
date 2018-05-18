package org.com.owl.utils.deleteRDirectory.beans;

import java.io.FileFilter;

import org.com.commons.io.file.DirectoryFile;
import org.com.commons.io.file.DirectoryFilter;
import org.com.commons.io.file.DirectoryProcessable;
import org.com.commons.io.file.FileDeleter;
import org.com.commons.io.file.FileProcessor;
import org.com.owl.utils.deleteRDirectory.filter.CustomDirectoryFilter;

public final class DeleteDirectoryProcessor {

    private final DirectoryProcessable processor;

    public DeleteDirectoryProcessor(
        final DirectoryProcessable processor) {
        super();
        this.processor = processor;
    }

    public boolean deleteDirectory(
        final DirectoryFile directory,
        final FileDeleter fileDeleter,
        final String[] directoriesName) {
        FileFilter fileFilter = fileFilter(directoriesName);
        FileProcessor fileProcessor = fileProcessor(fileDeleter);
        return processor.processDirectory(directory, fileFilter, fileProcessor);
    }

    private FileFilter fileFilter(
        final String[] names) {
        DirectoryFilter directoryFilter = new DirectoryFilter();
        return new CustomDirectoryFilter(directoryFilter, names);
    }

    private FileProcessor fileProcessor(
        final FileDeleter fileDeleter) {
        return file -> new DirectoryFile(file, fileDeleter).delete();
    }
}
