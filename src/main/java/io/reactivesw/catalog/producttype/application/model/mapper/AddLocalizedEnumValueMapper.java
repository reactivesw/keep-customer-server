package io.reactivesw.catalog.producttype.application.model.mapper;

import io.reactivesw.catalog.product.application.model.attributes.LocalizedEnumAttributeType;
import io.reactivesw.catalog.producttype.application.model.action.AddLocalizedEnumValue;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.common.model.LocalizedEnumValue;
import io.reactivesw.common.model.UpdateAction;

import java.util.Objects;

/**
 * Created by Davis on 16/12/12.
 */
public class AddLocalizedEnumValueMapper implements ProductTypeUpdateMapper<ProductTypeEntity> {
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    AddLocalizedEnumValue addLocalizedEnumValue = (AddLocalizedEnumValue) action;
    String attributeName = addLocalizedEnumValue.getAttributeName();
    LocalizedEnumValue value = addLocalizedEnumValue.getValue();

    entity.getAttributes().stream()
        .map(attribute -> {
          if (Objects.equals(attributeName, attribute.getName())) {
            LocalizedEnumAttributeType lenumAttribute = (LocalizedEnumAttributeType) attribute
                .getType();
            lenumAttribute.getValues().add(value);
            attribute.setType(lenumAttribute);
          }
          return attribute;
        });

  }
}
