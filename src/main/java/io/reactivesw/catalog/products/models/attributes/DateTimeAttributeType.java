package io.reactivesw.catalog.products.models.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class DateTimeAttributeType extends AttributeTypeBase {
    private DateTimeAttributeType() {}

    @JsonIgnore
    public static DateTimeAttributeType of() {
        return new DateTimeAttributeType();
    }
}
