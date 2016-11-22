package io.reactivesw.common.models;

import com.fasterxml.jackson.databind.JsonNode;

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
  private JsonNode fields;

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

  public JsonNode getFields() {
    return fields;
  }

  public void setFields(JsonNode fields) {
    this.fields = fields;
  }
}
