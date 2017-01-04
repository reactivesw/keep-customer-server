package io.reactivesw.catalog.taxcategory.domain.service.update;

import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.catalog.taxcategory.infrastructure.util.TaxCategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetDescription;

import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/11.
 */
@Service(value = TaxCategoryActionUtils.SET_DESCRIPTION)
public class SetDescriptionService implements Update<TaxCategoryEntity> {
  /**
   * set description.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(TaxCategoryEntity entity, UpdateAction action) {
    SetDescription setDescription = (SetDescription) action;
    entity.setDescription(setDescription.getDescription());
  }
}
