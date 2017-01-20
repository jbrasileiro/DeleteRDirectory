package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;

public class FileDeleterImp implements FileDeleter {

	@Override
	public boolean delete(File file) {
		boolean deleted = file.delete();
		toLog(file, deleted);
		return deleted;
	}

	private void toLog(File file, boolean deleted) {
		String message = String.format("%s %s : [%s]", deleted ? "deleted" : "not deleted", file.isDirectory() ? "directory" : "file", file.getPath()); 
		System.err.println(message); 
	}

}
