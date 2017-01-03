package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.product.application.model.attributes.EnumAttributeType;
import io.reactivesw.catalog.producttype.application.model.action.SetPlainEnumValueOrder;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.exception.NotExistException;
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
    if (entity.getAttributes() == null || entity.getAttributes().isEmpty()) {
      return ;
    }
    SetPlainEnumValueOrder setPlainEnumValueOrder = (SetPlainEnumValueOrder) action;

    String enumAttributeName = setPlainEnumValueOrder.getActionName();

    EnumAttributeType enumType = getEnumAttributeType(entity, enumAttributeName);
    List<String> enumValueKeys = getEnumAttributeKeys(enumType);

    List<String> orderKeys = getOrderKeys(setPlainEnumValueOrder);

    if (!CollectionUtils.isEqualCollection(orderKeys, enumValueKeys)) {
      throw new ParametersException(
          "The values must be equal to the values of the attribute enum values");
    }

    setEnumValueOrder(entity, enumAttributeName, enumType, orderKeys);
  }

  /**
   * Sets enum value order.
   *  @param entity                 the entity
   * @param enumAttributeName the set plain enum value order
   * @param enumType               the enum type
   * @param orderdKeys             the orderd keys
   */
  private void setEnumValueOrder(ProductTypeEntity entity, String
      enumAttributeName, EnumAttributeType enumType, List<String> orderdKeys) {
    enumType.setValues(enumType.getValues().parallelStream().sorted(
        (v1, v2) -> Integer.compare(orderdKeys.indexOf(v1.getKey()),
            orderdKeys.indexOf(v2.getKey()))
    ).collect(Collectors.toList()));

    entity.getAttributes().parallelStream().forEach(
        attribute -> {
          if (attribute.getName().equals(enumAttributeName)) {
            attribute.setType(enumType);
          }
        }
    );
  }

  /**
   * Gets orderd keys.
   *
   * @param setPlainEnumValueOrder the set plain enum value order
   * @return the orderd keys
   */
  private List<String> getOrderKeys(SetPlainEnumValueOrder setPlainEnumValueOrder) {
    return setPlainEnumValueOrder.getValues().parallelStream()
          .map(
              value -> {
                return value.getKey();
              }
          ).collect(Collectors.toList());
  }

  /**
   * Gets enum attribute keys.
   *
   * @param enumType the enum type
   * @return the enum attribute keys
   */
  private List<String> getEnumAttributeKeys(EnumAttributeType enumType) {
    return enumType.getValues().parallelStream().map(
          value -> {
            return value.getKey();
          }
      ).collect(Collectors.toList());
  }

  /**
   * Gets enum attribute type.
   *
   * @param entity                 the entity
   * @param enumAttributeName the set plain enum value order
   * @return the enum attribute type
   */
  private EnumAttributeType getEnumAttributeType(ProductTypeEntity entity,
                                                 String enumAttributeName) {
    List<AttributeDefinitionEntity> attributes = entity.getAttributes();
    Optional<AttributeDefinitionEntity> enumAttribute = attributes.parallelStream().filter(
        attribute -> attribute.getName().equals(enumAttributeName)
            && attribute.getType() instanceof EnumAttributeType
    ).findAny();

    if (!enumAttribute.isPresent()) {
      throw new NotExistException("can not find enum attribute type named : " + enumAttributeName);
    }
    return (EnumAttributeType) enumAttribute.get().getType();
  }
}
