package org.com.commons.io.file;

import java.io.FileFilter;

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
