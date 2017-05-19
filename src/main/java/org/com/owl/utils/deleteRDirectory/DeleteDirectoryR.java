package org.com.owl.utils.deleteRDirectory;

import java.io.File;

import org.com.owl.utils.deleteRDirectory.beans.DeleteDirectoryRArgumentProcessor;
import org.com.owl.utils.deleteRDirectory.beans.DeleteRDirectoryParameter;
import org.com.owl.utils.deleteRDirectory.beans.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.beans.DirectoryProcessor;
import org.com.owl.utils.deleteRDirectory.beans.FileDeleter;
import org.com.owl.utils.deleteRDirectory.beans.FileDeleterImp;
import org.com.owl.utils.deleteRDirectory.beans.FileDeleterVerify;
import org.com.owl.utils.deleteRDirectory.filter.CustomDirectoryFilter;
import org.com.owl.utils.deleteRDirectory.filter.DirectoryFilter;

public final class DeleteDirectoryR {

    private boolean debug = false;
    private boolean verify = false;

    public boolean run(
        final DeleteRDirectoryParameter parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("no parameters");
        } else {
            if (parameters.isDebug()) {
                debug = Boolean.TRUE;
            }
            if (parameters.isVerify()) {
                verify = Boolean.TRUE;
            }
            File file = parameters.getFile();
            if (debug) {
                System.out.println(file.getAbsolutePath());
            }
            return deleteRecursive(file, parameters.getDirectoriesName());
        }
    }

    public void run(
        final DeleteDirectoryRArgumentProcessor processor) {
        boolean result = run(processor.process());
        if (result) {
            System.out.println("OK");
        } else {
            System.err.println("ERROR");
        }
    }

    protected boolean deleteRecursive(
        final File file,
        final String directoryName) {
        return deleteRecursive(file, new String[] {
            directoryName
        });
    }

    protected boolean deleteRecursive(
        final File file,
        final String[] directoriesName) {
        DirectoryProcessor processor
            = new DirectoryProcessor(file, new CustomDirectoryFilter(directoriesName)) {

                @Override
                protected boolean doAction(
                    final File vDirectory) {
                    DirectoryFile directoryFile = new DirectoryFile(vDirectory, getFileDeleter());
                    return directoryFile.delete();
                }

                private FileDeleter getFileDeleter() {
                    return verify
                        ? new FileDeleterVerify()
                        : new FileDeleterImp();
                }
            };
        processor.process();
        DirectoryProcessor directoryProcessor
            = new DirectoryProcessor(file, new DirectoryFilter()) {

                @Override
                protected boolean doAction(
                    final File vDirectory) {
                    return deleteRecursive(vDirectory, directoriesName);
                }
            };
        directoryProcessor.process();
        return Boolean.TRUE;
    }
}
