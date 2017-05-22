package org.com.owl.utils.deleteRDirectory;

import org.com.owl.utils.deleteRDirectory.beans.DefaultDirectoryFilterProcessor;
import org.com.owl.utils.deleteRDirectory.beans.DefaultDirectoryProcessor;
import org.com.owl.utils.deleteRDirectory.beans.DeleteDirectoryProcessor;
import org.com.owl.utils.deleteRDirectory.beans.DirectoryProcessable;
import org.com.owl.utils.deleteRDirectory.beans.RecursiveDirectoryDeleter;
import org.com.owl.utils.deleteRDirectory.beans.RecursiveDirectoryProcessor;

public final class Factory {

    private Factory() {
        super();
        throw new IllegalStateException();
    }

    public static DeleteDirectoryR deleteDirectoryR() {
        return new DeleteDirectoryR(directoryDeleter());
    }

    public static RecursiveDirectoryDeleter directoryDeleter() {
        return new RecursiveDirectoryDeleter(deleter(), dProcessor());
    }

    private static DefaultDirectoryFilterProcessor dProcessor() {
        return new DefaultDirectoryFilterProcessor(processor());
    }

    public static RecursiveDirectoryProcessor rprocessor() {
        return new RecursiveDirectoryProcessor(processor(), directoryDeleter());
    }

    public static DeleteDirectoryProcessor deleter() {
        return new DeleteDirectoryProcessor(processor());
    }

    public static DirectoryProcessable processor() {
        return new DefaultDirectoryProcessor();
    }
}
