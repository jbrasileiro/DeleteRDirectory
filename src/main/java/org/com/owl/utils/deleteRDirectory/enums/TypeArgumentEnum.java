package org.com.owl.utils.deleteRDirectory.enums;

import org.com.owl.utils.deleteRDirectory.beans.DeleteRDirectoryParameter;

public enum TypeArgumentEnum {
	SOURCE(DeleteRDirectoryParameter.KEY_SOURCE, "SOURCE"),
	DEBUG(DeleteRDirectoryParameter.KEY_DEBUG, "DEBUG"),
	VERIFY(DeleteRDirectoryParameter.KEY_VERIFY, "VERIFY"),
	;
	private String key;
	private String meaning;

	TypeArgumentEnum(String key, String meaning) {
		this.key = key;
		this.meaning = meaning;
	}

	public String getKey() {
		return key;
	}

	public String getMeaning(TypeStringCase typeStringCase) {
		return meaning;
	}

	public String getArgument() {
		switch (this) {
		default:
			return String.format("--%s", getKey(TypeStringCase.UPPER_CASE));
		}
	}

	public String getKey(TypeStringCase type) {
		switch (type) {
		case UPPER_CASE:
			return key.toUpperCase();
		case LOWER_CASE:
			return key.toLowerCase();
		}
		throw new IllegalArgumentException("not implemented : ".concat(type.toString()));
	}

}
