package br.com.deleterdirectory.test;

import java.io.File;

import org.com.owl.utils.deleteRDirectory.DeleteRDirectoryParameter;

public final class DeleteRDirectoryParameterSub
    implements
    DeleteRDirectoryParameter {

    private final boolean debug;
    private final boolean verify;
    private final File file;
    private final String[] directories;

    public DeleteRDirectoryParameterSub(
        final boolean debug,
        final boolean verify,
        final File file,
        final String[] directories) {
        super();
        this.debug = debug;
        this.verify = verify;
        this.file = file;
        this.directories = directories;
    }

    @Override
    public boolean isDebug() {
        return debug;
    }

    @Override
    public boolean isVerify() {
        return verify;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public String[] getDirectoriesName() {
        return directories;
    }
}
