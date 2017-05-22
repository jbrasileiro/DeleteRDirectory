package br.com.core.test;

import java.io.File;
import java.util.List;

import org.junit.rules.TemporaryFolder;

public final class TFHandler {

    public void createFolder(
        final TemporaryFolder folder,
        final String name) {
        synchronized (this) {
            try {
                File directory = folder.newFolder(name);
                File file = File.createTempFile("tmp-", "", directory);
                while (!file.exists()) {
                    this.wait();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createFolder(
        final TemporaryFolder folder,
        final List<File> files) {
        for (File file : files) {
            createFolder(folder, file);
        }
    }

    public void createFolder(
        final TemporaryFolder folder,
        final File file) {
        createFolder(folder, file.getName());
    }
}
