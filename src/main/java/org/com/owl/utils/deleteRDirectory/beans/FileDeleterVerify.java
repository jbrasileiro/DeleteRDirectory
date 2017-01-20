package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;

public class FileDeleterVerify implements FileDeleter {

	@Override
	public boolean delete(File file) {
		System.out.println("- verifying -".concat(file.getPath()));
		return true;
	}

}
