package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.product.application.model.attributes.EnumAttributeType;
import io.reactivesw.catalog.producttype.application.model.action.AddPlainEnumValue;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.enums.EnumValue;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.mapper.EnumValueMapper;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.ADD_PLAIN_ENUM_VALUE)
public class AddPlainEnumValueService implements Update<ProductTypeEntity> {
  /**
   * add enum value.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    AddPlainEnumValue addPlainEnumValue = (AddPlainEnumValue) action;
    String attributeName = addPlainEnumValue.getAttributeName();
    EnumValue enumValue = EnumValueMapper.modelToEntity(addPlainEnumValue.getValue());

    entity.getAttributes()
        .stream().forEach(
        attribute -> {
          if (Objects.equals(attributeName, attribute.getName())) {
            EnumAttributeType enumAttributeType = (EnumAttributeType) attribute.getType();
            // TODO: 16/12/12 if values is null?
            enumAttributeType.getValues().add(enumValue);
            attribute.setType(enumAttributeType);
          }
        }
    );
  }
}
