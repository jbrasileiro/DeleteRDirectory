package org.com.owl.utils.deleteRDirectory.file;

import java.io.File;

import org.com.commons.io.file.FileDeleter;

public class FileDeleterImp implements FileDeleter {

	@Override
	public boolean delete(final File file) {
		boolean deleted = file.delete(); // TODO "java.nio.Files#delete" should be preferred (squid:S4042)
		toLog(file, deleted);
		return deleted;
	}

	private void toLog(final File file, final boolean deleted) {
		String message = String.format("%s %s : [%s]", deleted ? "deleted" : "not deleted", file.isDirectory() ? "directory" : "file", file.getPath());
		System.err.println(message);
	}

}
