package io.reactivesw.order.cartdiscount.application.model.mapper;

import io.reactivesw.common.model.mapper.LocalizedStringMapper;
import io.reactivesw.order.cartdiscount.application.model.CartDiscount;
import io.reactivesw.order.cartdiscount.application.model.CartDiscountDraft;
import io.reactivesw.order.cartdiscount.domain.entity.CartDiscountEntity;

/**
 * Created by umasuo on 16/12/22.
 */
public class CartDiscountMapper {

  public static CartDiscount entityToModel(CartDiscountEntity entity) {
    CartDiscount model = null;
    if (entity != null) {
      model = new CartDiscount();
      model.setId(entity.getId());
      model.setVersion(entity.getVersion());
      model.setCartPredicate(entity.getCartPredicate());
      model.setCreatedAt(entity.getCreatedAt());
      model.setDescription(LocalizedStringMapper.entityToModelDefaultNull(entity.getDescription()));
      model.setIsActive(entity.getActive());
      model.setLastModifiedAt(entity.getLastModifiedAt());
      model.setName(LocalizedStringMapper.entityToModelDefaultNull(entity.getName()));
      model.setSortOrder(entity.getSortOrder());
      model.setTarget(CartDiscountTargetMapper.entityToModel(entity.getTarget()));
      model.setValue(CartDiscountValueMapper.entityToModel(entity.getValue()));
      model.setRequiresDiscountCode(entity.getRequiresDiscountCode());
      model.setValidFrom(entity.getValidFrom());
      model.setValidUntil(entity.getValidUntil());
    }
    return model;
  }

  public static CartDiscountEntity modelToEntity(CartDiscountDraft model) {
    CartDiscountEntity entity = null;
    if (model != null) {
      entity = new CartDiscountEntity();
      entity.setCartPredicate(model.getCartPredicate());
      entity.setDescription(LocalizedStringMapper.modelToEntityDefaultNull(model.getDescription()));
      entity.setActive(model.getActive());
      entity.setName(LocalizedStringMapper.modelToEntityDefaultNull(model.getName()));
      entity.setSortOrder(model.getSortOrder());
      entity.setTarget(CartDiscountTargetMapper.modelToEntity(model.getTarget()));
      entity.setValue(CartDiscountValueMapper.modelToEntity(model.getValue()));
      entity.setRequiresDiscountCode(model.getRequiresDiscountCode());
      entity.setValidFrom(model.getValidFrom());
      entity.setValidUntil(model.getValidUntil());
    }
    return entity;
  }


}
