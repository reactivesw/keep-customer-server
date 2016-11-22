package io.reactivesw.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.reactivesw.common.models.Base;

final class EnumValueImpl extends Base implements EnumValue {
  private final String key;
  private final String label;

  @JsonCreator
  EnumValueImpl(final String key, final String label) {
    this.key = key;
    this.label = label;
  }

  @Override
  public String getKey() {
    return key;
  }

  public String getLabel() {
    return label;
  }
}
