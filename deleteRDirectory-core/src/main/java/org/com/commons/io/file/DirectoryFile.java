package org.com.commons.io.file;

import java.io.File;
import java.io.FileFilter;

public class DirectoryFile {

    private final File directory;
    private final FileDeleter fileDeleter;

    public DirectoryFile(
        final File directory,
        final FileDeleter fileDeleter) {
        if (directory.isFile()) {
            throw new IllegalArgumentException("Not a directory : ".concat(directory.getPath()));
        }
        this.directory = directory;
        this.fileDeleter = fileDeleter;
    }

    public boolean delete() {
        return delete(Boolean.TRUE);
    }

    public boolean delete(
        final boolean debug) {
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            return deleteDirectory(debug);
        } else {
            deleteFiles();
            return deleteDirectory(debug);
        }
    }

    private boolean deleteFiles() {
        boolean ok = Boolean.TRUE;
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                ok = new DirectoryFile(file, fileDeleter).delete(false) && ok
                    ? Boolean.TRUE
                    : Boolean.FALSE;
            } else {
                ok = fileDeleter.delete(file) && ok
                    ? Boolean.TRUE
                    : Boolean.FALSE;
            }
        }
        return ok;
    }

    private boolean deleteDirectory(
        final boolean debug) {
        if (fileDeleter.delete(directory)) {
            if (debug) {
                System.out.println("deleted ".concat(directory.getPath()));
            }
            return Boolean.TRUE;
        } else {
            if (debug) {
                System.err.println("not deleted ".concat(directory.getPath()));
            }
            return Boolean.FALSE;
        }
    }

    public File[] listFiles(
        final FileFilter fileFilter) {
        return directory.listFiles(fileFilter);
    }

    public FileDeleter getFileDeleter() {
        return fileDeleter;
    }
}
