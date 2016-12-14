package io.reactivesw.catalog.product.application.model.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ReferenceAttributeType extends AttributeTypeBase {

  private final String referenceTypeId;

  protected ReferenceAttributeType(final String referenceTypeId) {
    this.referenceTypeId = referenceTypeId;
  }

  public String getReferenceTypeId() {
    return referenceTypeId;
  }

  @JsonIgnore
  public static ReferenceAttributeType of(final String referenceTypeId) {
    return new ReferenceAttributeType(referenceTypeId);
  }
}
