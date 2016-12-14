package io.reactivesw.catalog.product.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class DateAttributeType extends AttributeTypeBase {
    private DateAttributeType() {}

    @JsonIgnore
    public static DateAttributeType of() {
        return new DateAttributeType();
    }
}
