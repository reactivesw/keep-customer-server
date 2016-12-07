package io.reactivesw.catalog.product.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class MoneyAttributeType extends AttributeTypeBase {
    private MoneyAttributeType() {}

    @JsonIgnore
    public static MoneyAttributeType of() {
        return new MoneyAttributeType();
    }
}
