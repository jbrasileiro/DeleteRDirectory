package org.com.owl.utils.deleteRDirectory.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.com.owl.utils.deleteRDirectory.enums.TypeArgumentEnum;

public final class DeleteDirectoryRArgumentProcessorImp
    implements
    DeleteDirectoryRArgumentProcessor,
    DeleteRDirectoryParameter {

    private final String[] args;

    public DeleteDirectoryRArgumentProcessorImp(
        final String[] args) {
        this.args = args;
    }

    public File getFile() {
        if (contains(TypeArgumentEnum.SOURCE)) {
            return extractFile();
        } else {
            throw new IllegalArgumentException("must have an source folder.");
        }
    }

    private boolean contains(
        final TypeArgumentEnum typeArgumentEnum) {
        if (args == null || typeArgumentEnum == null) {
            return false;
        } else {
            for (String key : args) {
                if (key.startsWith(typeArgumentEnum.getArgument())) {
                    return true;
                }
            }
            return false;
        }
    }

    private File extractFile() {
        String path = extractArgument(TypeArgumentEnum.SOURCE);
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(
                "File do not exist: ".concat(file.getAbsolutePath()));
        }
        return file;
    }

    private String extractArgument(
        final TypeArgumentEnum typeArgumentEnum) {
        if (args == null) {
            return null;
        } else {
            for (String arg : args) {
                if (arg.startsWith(typeArgumentEnum.getArgument())) {
                    return arg.replaceAll(typeArgumentEnum.getArgument(), "");
                }
            }
            throw new IllegalArgumentException(
                "Argument not found: ".concat(typeArgumentEnum.toString()));
        }
    }

    @Override
    public String[] getDirectoriesName() {
        List<String> names = new ArrayList<>();
        for (String arg : args) {
            boolean add = true;
            for (TypeArgumentEnum typeArg : TypeArgumentEnum.values()) {
                if (arg.startsWith(typeArg.getArgument())) {
                    add = false;
                    break;
                }
            }
            if (add) {
                names.add(arg);
            }
        }
        return names.toArray(new String[] {});
    }

    @Override
    public boolean isDebug() {
        return contains(TypeArgumentEnum.DEBUG);
    }

    @Override
    public boolean isVerify() {
        return contains(TypeArgumentEnum.VERIFY);
    }

    @Override
    public DeleteRDirectoryParameter process() {
        return this;
    }
}
