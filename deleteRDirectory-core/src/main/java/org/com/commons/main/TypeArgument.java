package org.com.commons.main;

public final class TypeArgument {

    private TypeArgument() {
        super();
        throw new IllegalArgumentException(getClass().toString());
    }

    public static final String KEY_SOURCE = "S";
    public static final String KEY_DEBUG = "debug";
    public static final String KEY_VERIFY = "V";
}
