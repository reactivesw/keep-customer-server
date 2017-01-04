package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.producttype.application.model.action.SetAttributeOrder;
import io.reactivesw.catalog.producttype.domain.entity.AttributeDefinitionEntity;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.SET_ATTRIBUTE_ORDER)
public class SetAttributeOrderService implements Update<ProductTypeEntity> {
  /**
   * change attribute order.
   * The attributes must be equal to the product type attributes (except for the order).
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    if (entity.getAttributes() == null || entity.getAttributes().isEmpty()) {
      return;
    }

    List<String> attributeName = getEntityAttributeNames(entity);

    List<String> orderdAttributeName = getOrderdAttributeNames((SetAttributeOrder) action);

    if (!CollectionUtils.isEqualCollection(attributeName, orderdAttributeName)) {
      throw new ParametersException("Attributes must be equal to the product type attributes");
    }

    List<AttributeDefinitionEntity> orderdAttributes = sortAttributeByOrder(entity,
        orderdAttributeName);

    entity.setAttributes(orderdAttributes);
  }

  /**
   * Sort attribute by order list.
   *
   * @param entity              the entity
   * @param orderdAttributeName the orderd attribute name
   * @return the list
   */
  private List<AttributeDefinitionEntity> sortAttributeByOrder(ProductTypeEntity entity,
                                                               List<String> orderdAttributeName) {
    return entity.getAttributes().stream()
          .sorted((a1, a2) ->
              Integer.compare(orderdAttributeName.indexOf(a1.getName()),
              orderdAttributeName.indexOf(a2.getName())))
          .collect(Collectors.toList());
  }

  /**
   * Gets orderd attribute names.
   *
   * @param action the action
   * @return the orderd attribute names
   */
  private List<String> getOrderdAttributeNames(SetAttributeOrder action) {
    return action.getAttributes().parallelStream()
          .map( attribute -> {
                return attribute.getName();
              }
          ).collect(Collectors.toList());
  }

  /**
   * Gets entity attribute names.
   *
   * @param entity the entity
   * @return the entity attribute names
   */
  private List<String> getEntityAttributeNames(ProductTypeEntity entity) {
    return entity.getAttributes().parallelStream().map(
          attribute -> {
            return attribute.getName();
          }
      ).collect(Collectors.toList());
  }
}
