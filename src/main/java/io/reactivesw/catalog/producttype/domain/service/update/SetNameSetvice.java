package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetName;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/30.
 */
@Service(value = ProductTypeActionUtils.SET_NAME)
public class SetNameSetvice implements Update<ProductTypeEntity> {
  /**
   * set product type name.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    SetName setName = (SetName)action;
    entity.setKey(setName.getName());
  }
}
