package org.com.owl.utils.deleteRDirectory.beans;

import java.io.FileFilter;

import org.com.owl.utils.deleteRDirectory.file.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.file.FileDeleter;
import org.com.owl.utils.deleteRDirectory.file.FileProcessor;
import org.com.owl.utils.deleteRDirectory.filter.CustomDirectoryFilter;
import org.com.owl.utils.deleteRDirectory.filter.DirectoryFilter;

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
