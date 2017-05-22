package org.com.owl.utils.deleteRDirectory.enums;

import org.com.owl.utils.deleteRDirectory.constant.TypeArgument;

public enum TypeArgumentEnum {
        SOURCE(TypeArgument.KEY_SOURCE,
            "SOURCE"),
        DEBUG(TypeArgument.KEY_DEBUG,
            "DEBUG"),
        VERIFY(TypeArgument.KEY_VERIFY,
            "VERIFY"),;

    private String key;
    private String meaning;

    TypeArgumentEnum(
        final String key,
        final String meaning) {
        this.key = key;
        this.meaning = meaning;
    }

    public String getKey() {
        return key;
    }

    public String getMeaning(
        final TypeStringCase key) {
        switch (key) {
            case LOWER_CASE:
                return meaning.toLowerCase();
            case UPPER_CASE:
                return meaning.toUpperCase();
            default:
                throw new IllegalArgumentException(key.toString());
        }
    }

    public String getArgument() {
        return String.format("--%s", getKey(TypeStringCase.UPPER_CASE));
    }

    public String getKey(
        final TypeStringCase type) {
        switch (type) {
            case UPPER_CASE:
                return key.toUpperCase();
            case LOWER_CASE:
                return key.toLowerCase();
            default:
                throw new IllegalArgumentException("not implemented : ".concat(type.toString()));
        }
    }
}
