package io.reactivesw.catalog.product.application.model.attributes;

import io.reactivesw.common.model.LocalizedEnumValue;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public final class LocalizedEnumAttributeType extends AttributeTypeBase {
  private List<LocalizedEnumValue> values;
}
