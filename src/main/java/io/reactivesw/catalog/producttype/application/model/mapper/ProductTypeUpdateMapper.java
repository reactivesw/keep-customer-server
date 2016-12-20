package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.producttype.application.model.action.AddAttribute;
import io.reactivesw.catalog.producttype.application.model.action.AddLocalizedEnumValue;
import io.reactivesw.catalog.producttype.application.model.action.AddPlainEnumValue;
import io.reactivesw.catalog.producttype.application.model.action.RemoveAttribute;
import io.reactivesw.catalog.producttype.application.model.action.SetAttributeInputTip;
import io.reactivesw.catalog.producttype.application.model.action.SetAttributeLabel;
import io.reactivesw.catalog.producttype.application.model.action.SetKey;
import io.reactivesw.common.model.action.SetDescription;
import io.reactivesw.common.model.action.SetName;
import io.reactivesw.common.model.Update;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by Davis on 16/12/7.
 */
public interface ProductTypeUpdateMapper<E> extends Update<E> {
  /**
   * ImmutableMap for discount code update mapper.
   */
  // TODO: 16/12/12
  // 1. Change the order of AttributeDefinitions
  // 2. Change the order of EnumValues
  // 3. Change the order of LocalizedEnumValues
  // 4. Change the label of an EnumValue
  // 5. Change the label of a LocalizedEnumValue
  // 6. Change AttributeDefinition IsSearchable
  Map<Class<?>, ProductTypeUpdateMapper> updateMappers = ImmutableMap.<Class<?>,
      ProductTypeUpdateMapper>builder()
      .put(SetKey.class, new SetKeyMapper())
      .put(SetName.class, new SetNameMapper())
      .put(SetDescription.class, new SetDescriptionMapper())
      .put(AddAttribute.class, new AddAttributeMapper())
      .put(RemoveAttribute.class, new RemoveAttributeMapper())
      .put(SetAttributeLabel.class, new SetAttributeLabelMapper())
      .put(SetAttributeInputTip.class, new SetAttributeLabelMapper())
      .put(AddPlainEnumValue.class, new AddPlainEnumValueMapper())
      .put(AddLocalizedEnumValue.class, new AddLocalizedEnumValueMapper())
      .build();

  /**
   * @param clazz
   * @return
   */
  static ProductTypeUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }
}