package io.reactivesw.common.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;

import io.reactivesw.common.entities.BaseIdEntity;

/**
 * Created by umasuo on 16/11/16.
 */
public class CustomFields extends BaseIdEntity{

  private Reference type;
  /**
   * A valid JSON object, based on {@code FieldDefinition}.
   * TODO
   */
  private String fields;

  public CustomFields() {
  }

//  @JsonCreator
  public CustomFields(Reference type, String fields) {
    this.type = type;
    this.fields = fields;
  }

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
