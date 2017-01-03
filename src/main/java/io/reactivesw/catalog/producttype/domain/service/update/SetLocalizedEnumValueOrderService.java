package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.product.application.model.attributes.LocalizedEnumAttributeType;
import io.reactivesw.catalog.producttype.application.model.action.SetLocalizedEnumValueOrder;
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
@Service(value = ProductTypeActionUtils.SET_LOCALIZED_ENUM_VALUE_ORDER)
public class SetLocalizedEnumValueOrderService implements Update<ProductTypeEntity> {
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
    SetLocalizedEnumValueOrder setLocalizedEnumValueOrder = (SetLocalizedEnumValueOrder) action;

    String localizedEnumAttributeName = setLocalizedEnumValueOrder.getActionName();

    LocalizedEnumAttributeType enumType =
        getLocalizedEnumAttributeType(entity, localizedEnumAttributeName);
    List<String> enumValueKeys = getLocalizedEnumAttributeKeys(enumType);

    List<String> orderKeys = getOrderKeys(setLocalizedEnumValueOrder);

    if (!CollectionUtils.isEqualCollection(orderKeys, enumValueKeys)) {
      throw new ParametersException(
          "The values must be equal to the values of the attribute enum values");
    }

    setEnumValueOrder(entity, localizedEnumAttributeName, enumType, orderKeys);
  }

  /**
   * Sets enum value order.
   *  @param entity                 the entity
   * @param localizedEnumAttributeName the set plain enum value order
   * @param enumType               the enum type
   * @param orderdKeys             the orderd keys
   */
  private void setEnumValueOrder(ProductTypeEntity entity, String
      localizedEnumAttributeName, LocalizedEnumAttributeType enumType, List<String> orderdKeys) {
    enumType.setValues(enumType.getValues().parallelStream().sorted(
        (v1, v2) -> Integer.compare(orderdKeys.indexOf(v1.getKey()),
            orderdKeys.indexOf(v2.getKey()))
    ).collect(Collectors.toList()));

    entity.getAttributes().parallelStream().forEach(
        attribute -> {
          if (attribute.getName().equals(localizedEnumAttributeName)) {
            attribute.setType(enumType);
          }
        }
    );
  }

  /**
   * Gets orderd keys.
   *
   * @param setLocalizedEnumValueOrder the set plain enum value order
   * @return the orderd keys
   */
  private List<String> getOrderKeys(SetLocalizedEnumValueOrder setLocalizedEnumValueOrder) {
    return setLocalizedEnumValueOrder.getValues().parallelStream()
          .map(
              value -> {
                return value.getKey();
              }
          ).collect(Collectors.toList());
  }

  /**
   * Gets enum attribute keys.
   *
   * @param localizedEnumAttributeType the enum type
   * @return the enum attribute keys
   */
  private List<String> getLocalizedEnumAttributeKeys(
      LocalizedEnumAttributeType localizedEnumAttributeType) {
    return localizedEnumAttributeType.getValues().parallelStream().map(
          value -> {
            return value.getKey();
          }
      ).collect(Collectors.toList());
  }

  /**g
   * Gets enum attribute type.
   *
   * @param entity                 the entity
   * @param localizedEnumAttributeName the set plain enum value order
   * @return the enum attribute type
   */
  private LocalizedEnumAttributeType getLocalizedEnumAttributeType(ProductTypeEntity entity,
                                                          String localizedEnumAttributeName) {
    List<AttributeDefinitionEntity> attributes = entity.getAttributes();
    Optional<AttributeDefinitionEntity> enumAttribute = attributes.parallelStream().filter(
        attribute -> attribute.getName().equals(localizedEnumAttributeName)
            && attribute.getType() instanceof LocalizedEnumAttributeType
    ).findAny();

    if (!enumAttribute.isPresent()) {
      throw new NotExistException("can not find enum attribute type named : " +
          localizedEnumAttributeName);
    }
    return (LocalizedEnumAttributeType) enumAttribute.get().getType();
  }
}
