package org.com.owl.utils.deleteRDirectory.file;

import java.io.File;

import org.com.commons.io.file.FileDeleter;

public class FileDeleterVerify
    implements
    FileDeleter {

    @Override
    public boolean delete(
        final File file) {
        System.out.println("- verifying -".concat(file.getPath()));
        return true;
    }
}
