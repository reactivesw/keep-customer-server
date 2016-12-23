package io.reactivesw.catalog.product.application.model.attributes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReferenceAttributeType extends AttributeTypeBase {
  private String referenceTypeId;
}
