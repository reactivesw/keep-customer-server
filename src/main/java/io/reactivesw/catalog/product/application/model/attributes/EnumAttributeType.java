package io.reactivesw.catalog.product.application.model.attributes;

import io.reactivesw.common.enums.EnumValue;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public final class EnumAttributeType extends AttributeTypeBase {
  private List<EnumValue> values;
}
