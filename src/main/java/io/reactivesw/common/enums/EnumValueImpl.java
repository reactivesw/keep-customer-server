package io.reactivesw.common.enums;

import io.reactivesw.common.model.Base;

import com.fasterxml.jackson.annotation.JsonCreator;

public final class EnumValueImpl extends Base implements EnumValue {
    private final String key;
    private final String label;

    @JsonCreator
    public EnumValueImpl(final String key, final String label) {
        this.key = key;
        this.label = label;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getLabel() {
        return label;
    }
}
