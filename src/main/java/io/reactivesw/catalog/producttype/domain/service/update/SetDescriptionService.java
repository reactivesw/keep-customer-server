package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetDescription;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/2.
 */
@Service(value = ProductTypeActionUtils.SET_DESCRIPTION)
public class SetDescriptionService implements Update<ProductTypeEntity> {
  /**
   * set product type description.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    SetDescription setDescription = (SetDescription) action;
    entity.setDescription(setDescription.getDescription());
  }
}
