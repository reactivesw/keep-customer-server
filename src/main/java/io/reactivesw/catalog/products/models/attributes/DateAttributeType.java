package io.reactivesw.catalog.products.models.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class DateAttributeType extends AttributeTypeBase {
    private DateAttributeType() {}

    @JsonIgnore
    public static DateAttributeType of() {
        return new DateAttributeType();
    }
}
