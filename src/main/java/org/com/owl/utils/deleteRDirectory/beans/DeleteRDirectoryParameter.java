package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;

public interface DeleteRDirectoryParameter {
	public final String KEY_SOURCE = "S";
	public final String KEY_DEBUG = "debug";
	public final String KEY_VERIFY = "V";

	public abstract boolean isDebug();

	public abstract boolean isVerify();

	public abstract File getFile();

	public abstract String[] getDirectoriesName();

}