package org.com.owl.utils.deleteRDirectory.beans;

import java.io.FileFilter;

import org.com.owl.utils.deleteRDirectory.file.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.file.FileProcessor;
import org.com.owl.utils.deleteRDirectory.filter.DirectoryFilter;

public final class DefaultDirectoryFilterProcessor
    implements
    DirectoryFilterProcessor {

    private final DirectoryProcessable processor;

    public DefaultDirectoryFilterProcessor(
        final DirectoryProcessable processor) {
        super();
        this.processor = processor;
    }

    @Override
    public final boolean processDirectory(
        final DirectoryFile directory,
        final FileProcessor fileProcessor) {
        return processor.processDirectory(directory, fileFilter(), fileProcessor);
    }

    private FileFilter fileFilter() {
        return new DirectoryFilter();
    }
}
