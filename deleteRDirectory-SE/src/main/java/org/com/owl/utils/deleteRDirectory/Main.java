package org.com.owl.utils.deleteRDirectory;

import org.com.owl.utils.deleteRDirectory.beans.DeleteDirectoryRArgumentProcessorImp;

public class Main {

    public static void main(
        final String[] args)
        throws Exception {
        Factory.deleteDirectoryR().run(toProcessor(args));
    }

    public static DeleteRDirectoryParameter toProcessor(
        final String[] args) {
        return new DeleteDirectoryRArgumentProcessorImp(args);
    }
}
