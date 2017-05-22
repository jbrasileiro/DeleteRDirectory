package br.com.deleterdirectory.test;

import java.io.File;

import org.com.owl.utils.deleteRDirectory.filter.DirectoryFilter;
import org.hamcrest.Description;

import br.com.core.test.AbstractBaseMatcherType;

public final class SubDirectoryCountMatcher
    extends
    AbstractBaseMatcherType<File> {

    private final int lenght;

    public SubDirectoryCountMatcher(
        final int lenght) {
        super();
        this.lenght = lenght;
    }

    @Override
    protected boolean execute(
        final File o) {
        File[] files = o.listFiles(new DirectoryFilter());
        return files.length == lenght;
    }

    @Override
    public void describeTo(
        final Description arg0) {
    }
}
