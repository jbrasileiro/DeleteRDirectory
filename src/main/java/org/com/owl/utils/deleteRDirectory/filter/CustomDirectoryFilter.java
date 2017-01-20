package org.com.owl.utils.deleteRDirectory.filter;

import java.io.File;
import java.io.FileFilter;

public class CustomDirectoryFilter implements FileFilter {

	private String[] names;

	public CustomDirectoryFilter(String[] names) {
		super();
		this.names = names;
	}

	@Override
	public boolean accept(File file) {
		if (file.isDirectory() && contains(file.getName())) {
			return true;
		} else {
			return false;
		}
	}

	private boolean contains(String name) {
		for (String vValue : names) {
			if (vValue.equals(name)) {
				return true;
			}
		}
		return false;
	}

}