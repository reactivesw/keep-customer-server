package io.reactivesw.order.discountcode.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;

/**
 * Created by umasuo on 16/12/7.
 */
public class DescriptionMapper implements DiscountCodeUpdateMapper<DiscountCodeEntity> {

  /**
   * set discount code description.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(DiscountCodeEntity entity, UpdateAction action) {
    SetLocalizedDescription description = (SetLocalizedDescription) action;
    entity.setDescription(LocalizedStringMapper.modelToEntityDefaultNew(description
        .getDescription()));
  }
}
