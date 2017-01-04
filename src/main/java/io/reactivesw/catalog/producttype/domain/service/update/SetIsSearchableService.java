package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.producttype.application.model.action.SetIsSearchable;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/3.
 */
@Service(value = ProductTypeActionUtils.SET_ATTRIBUTE_DEFINITION_IS_SEARCHABLE)
public class SetIsSearchableService implements Update<ProductTypeEntity> {
  /**
   * set isSearchable to attribute.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    if (entity.getAttributes() == null || entity.getAttributes().isEmpty()) {
      return;
    }

    SetIsSearchable setIsSearchable = (SetIsSearchable) action;

    entity.getAttributes().forEach(
        attribute -> {
          if (attribute.getName().equals(setIsSearchable.getAttributeName())) {
            attribute.setSearchable(setIsSearchable.getIsSearchable());
          }
        }
    );
  }
}
