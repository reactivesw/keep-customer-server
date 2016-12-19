package io.reactivesw.common.model.mapper;

import io.reactivesw.common.enums.EnumValue;
import io.reactivesw.common.model.PlainEnumValue;

/**
 * Created by Davis on 16/12/12.
 */
public final class EnumValueMapper {
  public static EnumValue modelToEntity(PlainEnumValue plainEnumValue) {
    return new EnumValue(plainEnumValue.getKey(), plainEnumValue.getLabel());
  }
}
