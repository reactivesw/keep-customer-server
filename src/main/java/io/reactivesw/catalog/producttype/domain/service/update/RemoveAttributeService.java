package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.producttype.application.model.action.RemoveAttributeDefinition;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/12.
 */
@Service(value = ProductTypeActionUtils.REMOVE_ATTRIBUTE_DEFINITION)
public class RemoveAttributeService implements Update<ProductTypeEntity> {
  /**
   * remove attribute from product type.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    String attributeName = ((RemoveAttributeDefinition) action).getName();

    List updateAttributes = entity.getAttributes().stream().filter(
        attribute -> !Objects.equals(attribute.getName(), attributeName)
    ).collect(Collectors.toList());

    if (updateAttributes.size() == entity.getAttributes().size()) {
      throw new NotExistException("can not find attribute by name : " + attributeName);
    }

    entity.setAttributes(updateAttributes);
  }
}

