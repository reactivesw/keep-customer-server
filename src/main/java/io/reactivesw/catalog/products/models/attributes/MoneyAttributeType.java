package io.reactivesw.catalog.products.models.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class MoneyAttributeType extends AttributeTypeBase {
    private MoneyAttributeType() {}

    @JsonIgnore
    public static MoneyAttributeType of() {
        return new MoneyAttributeType();
    }
}
