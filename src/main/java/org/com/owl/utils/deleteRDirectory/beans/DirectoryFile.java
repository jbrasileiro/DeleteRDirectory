package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;

public class DirectoryFile {

	private File directory;
	private FileDeleter fileDeleter;

	public DirectoryFile(File directory, FileDeleter fileDeleter) {
		this.directory = directory;
		this.fileDeleter = fileDeleter;
	}

	public boolean delete() {
		return delete(Boolean.TRUE);
	}

	public boolean delete(boolean debug) {
		File[] files = directory.listFiles();
		if (files == null || files.length == 0) {
			return deleteDirectory(debug);
		} else {
			deleteFiles();
			return deleteDirectory(debug);
		}
	}

	private boolean deleteFiles() {
		boolean ok = Boolean.TRUE;
		for (File file : directory.listFiles()) {
			if (file.isDirectory()) {
				ok = new DirectoryFile(file, fileDeleter).delete(false) && ok ? Boolean.TRUE : Boolean.FALSE;
			} else {
				ok = fileDeleter.delete(file) && ok ? Boolean.TRUE : Boolean.FALSE;
			}
		}
		return ok;
	}

	private boolean deleteDirectory(boolean debug) {
		if (fileDeleter.delete(directory)) {
			if (debug) {
				System.out.println("deleted ".concat(directory.getPath()));
			}
			return Boolean.TRUE;
		} else {
			if (debug) {
				System.err.println("not deleted ".concat(directory.getPath()));
			}
			return Boolean.FALSE;
		}
	}

}