package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.product.application.model.attributes.EnumAttributeType;
import io.reactivesw.catalog.producttype.application.model.action.SetPlainEnumValueOrder;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Davis on 17/1/2.
 */
@Service(value = ProductTypeActionUtils.SET_ENUM_VALUE_ORDER)
public class SetPlainEnumValueOrderService implements Update<ProductTypeEntity> {
  /**
   * set plain enum value order.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    SetPlainEnumValueOrder setPlainEnumValueOrder = (SetPlainEnumValueOrder) action;
    List<AttributeDefinitionEntity> attributes = entity.getAttributes();
    Optional<AttributeDefinitionEntity> enumAttribute = attributes.parallelStream().filter(
        attribute -> attribute.getName().equals(setPlainEnumValueOrder.getActionName())
    ).findAny();

    if (!enumAttribute.isPresent()) {
      return;
    }
    List<String> orderdKeys = setPlainEnumValueOrder.getValues().parallelStream()
        .map(
            value -> {
              return value.getKey();
            }
        ).collect(Collectors.toList());
    EnumAttributeType enumType = (EnumAttributeType) enumAttribute.get().getType();
    List<String> enumValueKeys = enumType.getValues().parallelStream().map(
        value -> {
          return value.getKey();
        }
    ).collect(Collectors.toList());

    if (!CollectionUtils.isEqualCollection(orderdKeys, enumValueKeys)) {
      throw new ParametersException(
          "The values must be equal to the values of the attribute enum values");
    }

    enumType.setValues(enumType.getValues().parallelStream().sorted(
        (v1, v2) -> Integer.compare(orderdKeys.indexOf(v1.getKey()),
            orderdKeys.indexOf(v2.getKey()))
    ).collect(Collectors.toList()));

    entity.getAttributes().parallelStream().forEach(
        attribute -> {
          if (attribute.getName().equals(setPlainEnumValueOrder.getActionName())) {
            attribute.setType(enumType);
          }
        }
    );
  }
}
