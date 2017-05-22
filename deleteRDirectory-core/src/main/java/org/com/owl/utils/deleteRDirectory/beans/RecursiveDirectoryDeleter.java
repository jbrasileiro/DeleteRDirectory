package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;

import org.com.owl.utils.deleteRDirectory.file.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.file.FileDeleter;
import org.com.owl.utils.deleteRDirectory.file.FileProcessor;

public final class RecursiveDirectoryDeleter {

    private final DeleteDirectoryProcessor deleter;
    private final DefaultDirectoryFilterProcessor directoryProcessor;

    public RecursiveDirectoryDeleter(
        final DeleteDirectoryProcessor deleter,
        final DefaultDirectoryFilterProcessor directoryProcessor) {
        super();
        this.deleter = deleter;
        this.directoryProcessor = directoryProcessor;
    }

    public boolean delete(
        final File file,
        final String[] directories,
        final FileDeleter fileDeleter) {
        deleteDirectoryProcessor(file, directories, fileDeleter);
        recursiveDirectoryProcessor(file, directories, fileDeleter);
        return Boolean.TRUE;
    }

    private boolean deleteDirectoryProcessor(
        final File file,
        final String[] directoriesName,
        final FileDeleter fileDeleter) {
        DirectoryFile directory = new DirectoryFile(file, fileDeleter);
        return deleter.deleteDirectory(directory, fileDeleter, directoriesName);
    }

    private boolean recursiveDirectoryProcessor(
        final File file,
        final String[] directoriesName,
        final FileDeleter fileDeleter) {
        DirectoryFile directory = new DirectoryFile(file, fileDeleter);
        return directoryProcessor.processDirectory(directory,
            fileProcessor(directoriesName, fileDeleter));
    }

    private FileProcessor fileProcessor(
        final String[] directoriesName,
        final FileDeleter fileDeleter) {
        return file -> delete(file, directoriesName, fileDeleter);
    }
}
