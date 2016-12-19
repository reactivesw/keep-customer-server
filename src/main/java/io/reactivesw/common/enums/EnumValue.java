package io.reactivesw.common.enums;

import io.reactivesw.common.model.Base;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class EnumValue {
  private String key;
  private String label;
}
