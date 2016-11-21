package io.reactivesw.types.models;

import io.reactivesw.common.models.Reference;

/**
 * Created by umasuo on 16/11/16.
 */
public class CustomFields {

  private Reference type;
  /**
   * A valid JSON object, based on {@code FieldDefinition}.
   * TODO
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
