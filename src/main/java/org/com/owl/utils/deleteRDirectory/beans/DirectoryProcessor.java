package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;
import java.io.FileFilter;

public abstract class DirectoryProcessor {
	private File file;
	private FileFilter fileFilter;

	public DirectoryProcessor(File file, FileFilter fileFilter) {
		super();
		this.file = file;
		this.fileFilter = fileFilter;
	}

	public boolean process() {
		File[] directories = file.listFiles(fileFilter);
		if (directories == null) {
			return Boolean.TRUE;
		} else {
			boolean isOK = Boolean.TRUE;
			for (File vDirectory : directories) {
				isOK = doAction(vDirectory) && isOK ? Boolean.TRUE : Boolean.FALSE;
			}
			return isOK;
		}
	}

	protected abstract boolean doAction(File vDirectory);

}