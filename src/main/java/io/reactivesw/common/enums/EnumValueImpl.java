package io.reactivesw.common.enums;

import io.reactivesw.common.model.Base;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;

@Data
public final class EnumValueImpl {
  private final String key;
  private final String label;

  @JsonCreator
  public EnumValueImpl(final String key, final String label) {
    this.key = key;
    this.label = label;
  }
}
