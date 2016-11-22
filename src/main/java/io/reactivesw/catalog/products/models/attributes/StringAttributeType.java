package io.reactivesw.catalog.products.models.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;

//TOOD copy from sdk, should be TextType
public final class StringAttributeType extends AttributeTypeBase {
    private StringAttributeType() {}

    @JsonIgnore
    public static StringAttributeType of() {
        return new StringAttributeType();
    }
}
