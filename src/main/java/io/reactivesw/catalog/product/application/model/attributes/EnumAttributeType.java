package io.reactivesw.catalog.product.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.reactivesw.common.enums.EnumValue;
import io.reactivesw.common.enums.EnumValueImpl;

import java.util.List;

import static io.reactivesw.common.util.ReactiveswInternalUtils.listOf;

public final class EnumAttributeType extends AttributeTypeBase {
    private final List<EnumValueImpl> values;

    @JsonCreator
    private EnumAttributeType(final List<EnumValueImpl> values) {
        this.values = values;
    }

    public List<EnumValueImpl> getValues() {
        return values;
    }

    @JsonIgnore
    public static EnumAttributeType of(final EnumValueImpl mandatoryValue, final EnumValueImpl... moreValues) {
        return of(listOf(mandatoryValue, moreValues));
    }

    @JsonIgnore
    public static EnumAttributeType of(final List<EnumValueImpl> values) {
        return new EnumAttributeType(values);
    }
}
