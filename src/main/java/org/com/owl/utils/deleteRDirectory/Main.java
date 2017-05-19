package org.com.owl.utils.deleteRDirectory;

import org.com.owl.utils.deleteRDirectory.beans.DeleteDirectoryRArgumentProcessorImp;
import org.com.owl.utils.deleteRDirectory.beans.DeleteRDirectoryParameter;

public class Main {

    public static void main(
        final String[] args)
        throws Exception {
        new DeleteDirectoryR().run(toProcessor(args));
    }

    private static DeleteRDirectoryParameter toProcessor(
        final String[] args) {
        return new DeleteDirectoryRArgumentProcessorImp(args);
    }
}


