package io.reactivesw.catalog.product.application.model.attributes;

import io.reactivesw.common.enums.EnumValue;

import lombok.Data;

import java.util.List;

@Data
public final class EnumAttributeType extends AttributeTypeBase {
  private List<EnumValue> values;
}
