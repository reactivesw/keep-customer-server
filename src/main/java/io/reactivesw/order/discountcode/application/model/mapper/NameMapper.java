package io.reactivesw.order.discountcode.application.model.mapper;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.action.SetLocalizedName;
import io.reactivesw.common.model.mapper.LocalizedStringMapper;
import io.reactivesw.order.discountcode.domain.entity.DiscountCodeEntity;

/**
 * Created by umasuo on 16/12/7.
 */
public class NameMapper implements DiscountCodeUpdateMapper<DiscountCodeEntity> {

  /**
   * set action name.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void setAction(DiscountCodeEntity entity, UpdateAction action) {
    SetLocalizedName setLocalizedName = (SetLocalizedName) action;
    entity.setName(LocalizedStringMapper.convertToLocalizedStringEntity(setLocalizedName.getName
        ()));
  }
}
