package org.deleterdirectory.it;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.com.owl.utils.deleteRDirectory.DeleteDirectoryR;
import org.com.owl.utils.deleteRDirectory.DeleteRDirectoryParameter;
import org.com.owl.utils.deleteRDirectory.Factory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import br.com.core.test.TFHandler;
import br.com.deleterdirectory.test.DeleteRDirectoryParameterSub;
import br.com.deleterdirectory.test.SubDirectoryCountMatcher;
import br.com.deleterdirectory.test.SubDirectoryMatcher;

public class DeleteDirectoryRIT {

    private static final String DELETE = "delete";
    private static final String[] DELETE_ONE_FOLDER = new String[] {
        DELETE
    };
    private DeleteDirectoryR instance;
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private TFHandler handler;

    @Before
    public void setUp() {
        instance = Factory.deleteDirectoryR();
        handler = new TFHandler();
    }

    @After
    public void after() {
        folder.delete();
    }

    private File subFolder(
        final String subFolder) {
        File root = folder.getRoot();
        return new File(root.getPath().concat("//".concat(subFolder)));
    }

    @Test
    public void deleteNonExistentFolderWithVerify() {
        List<File> expected = Arrays.asList(subFolder("folder"));
        handler.createFolder(folder, expected);
        File root = folder.getRoot();
        Assert.assertTrue(instance.run(processor(root, true, DELETE_ONE_FOLDER)));
        Assert.assertThat(root, new SubDirectoryCountMatcher(1));
        Assert.assertThat(root, new SubDirectoryMatcher(expected));
    }

    @Test
    public void deleteNonExistentFolder() {
        List<File> expected = Arrays.asList(subFolder("folder"));
        handler.createFolder(folder, expected);
        File root = folder.getRoot();
        Assert.assertTrue(instance.run(processor(root, false, DELETE_ONE_FOLDER)));
        Assert.assertThat(root, new SubDirectoryCountMatcher(1));
        Assert.assertThat(root, new SubDirectoryMatcher(expected));
    }

    @Test
    public void deleteExistentFolderWithVerify() {
        List<File> expected = Arrays.asList(subFolder(DELETE));
        handler.createFolder(folder, expected);
        File root = folder.getRoot();
        Assert.assertTrue(instance.run(processor(root, true, DELETE_ONE_FOLDER)));
        Assert.assertThat(root, new SubDirectoryCountMatcher(1));
        Assert.assertThat(root, new SubDirectoryMatcher(expected));
    }

    @Test
    public void deleteExistentFolder() {
        handler.createFolder(folder, subFolder(DELETE));
        File root = folder.getRoot();
        Assert.assertTrue(instance.run(processor(root, false, DELETE_ONE_FOLDER)));
        Assert.assertThat(root, new SubDirectoryCountMatcher(0));
    }

    private DeleteRDirectoryParameter processor(
        final File file,
        final boolean verify,
        final String[] directories) {
        return new DeleteRDirectoryParameterSub(true, verify, file, directories);
    }
}

enum TypeFile {
        FILE,
        DIRECTORY;
}
