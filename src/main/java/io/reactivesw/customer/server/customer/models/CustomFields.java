package io.reactivesw.customer.server.customer.models;

import io.reactivesw.customer.server.common.types.Reference;

/**
 * Created by umasuo on 16/11/16.
 */
public class CustomFields {

  private Reference type;
  /**
   * A valid JSON object, based on {@code FieldDefinition}.
   */
  private String fields;

  @Override
  public String toString() {
    return "CustomFields{" +
            "type=" + type +
            ", fields='" + fields + '\'' +
            '}';
  }

  public Reference getType() {
    return type;
  }

  public void setType(Reference type) {
    this.type = type;
  }

  public String getFields() {
    return fields;
  }

  public void setFields(String fields) {
    this.fields = fields;
  }
}
