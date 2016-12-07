package io.reactivesw.common.enums;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.reactivesw.common.model.LocalizedString;

@JsonDeserialize(as = LocalizedEnumValueImpl.class)
public interface LocalizedEnumValue extends WithKey {
  static LocalizedEnumValue of(final String key, final LocalizedString label) {
    return new LocalizedEnumValueImpl(key, label);
  }

  @Override
  String getKey();

  LocalizedString getLabel();

  static TypeReference<LocalizedEnumValue> typeReference() {
    return new TypeReference<LocalizedEnumValue>() {
      @Override
      public String toString() {
        return "TypeReference<LocalizedEnumValue>";
      }
    };
  }
}
