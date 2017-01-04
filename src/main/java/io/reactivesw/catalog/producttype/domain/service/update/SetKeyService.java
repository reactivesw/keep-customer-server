package io.reactivesw.catalog.producttype.domain.service.update;

import io.reactivesw.catalog.producttype.application.model.action.SetKey;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 17/1/2.
 */
@Service(value = ProductTypeActionUtils.SET_KEY)
public class SetKeyService implements Update<ProductTypeEntity> {

  /**
   * set product type key.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(ProductTypeEntity entity, UpdateAction action) {
    SetKey setKey = (SetKey)action;
    entity.setKey(setKey.getKey());
  }
}
