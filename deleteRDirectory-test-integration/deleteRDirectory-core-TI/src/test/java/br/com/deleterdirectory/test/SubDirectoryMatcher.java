package br.com.deleterdirectory.test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.com.commons.io.file.DirectoryFilter;
import org.hamcrest.Description;

import br.com.core.test.AbstractBaseMatcherType;

public final class SubDirectoryMatcher
    extends
    AbstractBaseMatcherType<File> {

    private final File[] files;

    public SubDirectoryMatcher(
        final List<File> files) {
        this(files.toArray(new File[] {}));
    }

    public SubDirectoryMatcher(
        final File[] files) {
        super();
        this.files = files;
    }

    @Override
    public void describeTo(
        final Description arg0) {
    }

    @Override
    protected boolean execute(
        final File o) {
        File[] actualFiles = o.listFiles(new DirectoryFilter());
        return Arrays.equals(actualFiles, files);
    }
}
