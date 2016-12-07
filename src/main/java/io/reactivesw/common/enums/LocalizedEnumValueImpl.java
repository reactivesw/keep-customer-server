package io.reactivesw.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.reactivesw.common.model.Base;
import io.reactivesw.common.model.LocalizedString;

final class LocalizedEnumValueImpl extends Base implements LocalizedEnumValue {
  private final String key;
  private final LocalizedString label;

  @JsonCreator
  LocalizedEnumValueImpl(final String key, final LocalizedString label) {
    this.key = key;
    this.label = label;
  }

  @Override
  public String getKey() {
    return key;
  }

  public LocalizedString getLabel() {
    return label;
  }
}
