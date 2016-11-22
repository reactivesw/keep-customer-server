package io.reactivesw.catalog.products.models.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class NumberAttributeType extends AttributeTypeBase {
    private NumberAttributeType() {}

    @JsonIgnore
    public static NumberAttributeType of() {
        return new NumberAttributeType();
    }
}
