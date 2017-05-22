package org.com.owl.utils.deleteRDirectory;

import java.io.File;

public interface DeleteRDirectoryParameter {

    public abstract boolean isDebug();

    public abstract boolean isVerify();

    public abstract File getFile();

    public abstract String[] getDirectoriesName();
}
