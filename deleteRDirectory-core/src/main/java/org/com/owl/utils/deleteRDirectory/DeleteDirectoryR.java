package org.com.owl.utils.deleteRDirectory;

import java.io.File;

import org.com.commons.io.file.FileDeleter;
import org.com.owl.utils.deleteRDirectory.beans.RecursiveDirectoryDeleter;
import org.com.owl.utils.deleteRDirectory.file.FileDeleterImp;
import org.com.owl.utils.deleteRDirectory.file.FileDeleterVerify;

public final class DeleteDirectoryR {

    private final RecursiveDirectoryDeleter recursiveDirectoryDeleter;

    public DeleteDirectoryR(
        final RecursiveDirectoryDeleter recursiveDirectoryDeleter) {
        super();
        this.recursiveDirectoryDeleter = recursiveDirectoryDeleter;
    }

    public boolean run(
        final DeleteRDirectoryParameter parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("no parameters");
        } else {
            File file = parameters.getFile();
            if (parameters.isDebug()) {
                System.out.println(file.getAbsolutePath());
            }
            String[] directories = parameters.getDirectoriesName();
            if(directories == null || directories.length==0){
                throw new IllegalArgumentException("");
            }
            FileDeleter fileDeleter = getFileDeleter(parameters);
            return recursiveDirectoryDeleter.delete(file, directories, fileDeleter);
        }
    }

    private FileDeleter getFileDeleter(
        final DeleteRDirectoryParameter parameters) {
        if (parameters.isVerify()) {
            return new FileDeleterVerify();
        } else {
            return new FileDeleterImp();
        }
    }
}
