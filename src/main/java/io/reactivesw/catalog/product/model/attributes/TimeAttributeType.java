package io.reactivesw.catalog.product.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class TimeAttributeType extends AttributeTypeBase {
    private TimeAttributeType() {}

    @JsonIgnore
    public static TimeAttributeType of() {
        return new TimeAttributeType();
    }
}
