package org.com.owl.utils.deleteRDirectory;

import java.io.File;

import org.com.owl.utils.deleteRDirectory.beans.DeleteDirectoryRArgumentProcessor;
import org.com.owl.utils.deleteRDirectory.beans.DeleteDirectoryRArgumentProcessorImp;
import org.com.owl.utils.deleteRDirectory.beans.DeleteRDirectoryParameter;
import org.com.owl.utils.deleteRDirectory.beans.DirectoryFile;
import org.com.owl.utils.deleteRDirectory.beans.DirectoryProcessor;
import org.com.owl.utils.deleteRDirectory.beans.FileDeleter;
import org.com.owl.utils.deleteRDirectory.beans.FileDeleterImp;
import org.com.owl.utils.deleteRDirectory.beans.FileDeleterVerify;
import org.com.owl.utils.deleteRDirectory.filter.CustomDirectoryFilter;
import org.com.owl.utils.deleteRDirectory.filter.DirectoryFilter;

public class Main {
	public static void main(String[] args) throws Exception {
		DeleteDirectoryRArgumentProcessor processor = new DeleteDirectoryRArgumentProcessorImp(args);
		DeleteDirectoryR deleteDirectoryR = new DeleteDirectoryR();
		System.err.println(deleteDirectoryR.run(processor.process()) ? "OK" : "ERROR");
	}
}

class DeleteDirectoryR {
	private boolean debug = false;
	private boolean verify = false;

	public boolean run(DeleteRDirectoryParameter parameters) {
		if (parameters == null) {
			throw new IllegalArgumentException("no parameters");
		} else {
			if (parameters.isDebug()) {
				this.debug = Boolean.TRUE;
			}
			if (parameters.isVerify()) {
				this.verify = Boolean.TRUE;
			}

			File file = parameters.getFile();
			if (this.debug) {
				System.out.println(file.getAbsolutePath());
			}
			return deleteRecursive(file, parameters.getDirectoriesName());
		}
	}

	protected boolean deleteRecursive(File file, String directoryName) {
		return deleteRecursive(file, new String[] { directoryName });
	}

	protected boolean deleteRecursive(File file, final String[] directoriesName) {
		DirectoryProcessor processor = new DirectoryProcessor(file, new CustomDirectoryFilter(directoriesName)) {
			@Override
			protected boolean doAction(File vDirectory) {
				DirectoryFile directoryFile = new DirectoryFile(vDirectory, getFileDeleter());
				return directoryFile.delete();
			}

			private FileDeleter getFileDeleter() {
				return verify ? new FileDeleterVerify() : new FileDeleterImp();
			}
		};
		processor.process();
		DirectoryProcessor directoryProcessor = new DirectoryProcessor(file, new DirectoryFilter()) {
			@Override
			protected boolean doAction(File vDirectory) {
				return deleteRecursive(vDirectory, directoriesName);
			}
		};
		directoryProcessor.process();
		return Boolean.TRUE;
	}

}
