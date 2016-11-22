package io.reactivesw.catalog.products.models.attributes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.reactivesw.common.enums.EnumValue;

import java.util.List;

import static io.reactivesw.common.utils.ReactiveswInternalUtils.listOf;

public final class EnumAttributeType extends AttributeTypeBase {
    private final List<EnumValue> values;

    @JsonCreator
    private EnumAttributeType(final List<EnumValue> values) {
        this.values = values;
    }

    public List<EnumValue> getValues() {
        return values;
    }

    @JsonIgnore
    public static EnumAttributeType of(final EnumValue mandatoryValue, final EnumValue... moreValues) {
        return of(listOf(mandatoryValue, moreValues));
    }

    @JsonIgnore
    public static EnumAttributeType of(final List<EnumValue> values) {
        return new EnumAttributeType(values);
    }
}
