package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.order.cart.application.model.ShippingInfo;
import io.reactivesw.order.order.domain.entity.value.ShippingInfoValue;

/**
 * Created by Davis on 17/2/6.
 */
public final class ShippingInfoMapper {
  /**
   * Instantiates a new Shipping info mapper.
   */
  private ShippingInfoMapper() {
  }

  /**
   * Model to entity shipping info value.
   *
   * @param model the model
   * @return the shipping info value
   */
  public static ShippingInfoValue modelToEntity(ShippingInfo model) {
    ShippingInfoValue entity = new ShippingInfoValue();

    // TODO: 17/2/6
    
    return entity;
  }

  /**
   * Entity to model shipping info.
   *
   * @param shippingInfo the shipping info
   * @return the shipping info
   */
  public static ShippingInfo entityToModel(ShippingInfoValue shippingInfo) {
    ShippingInfo model = new ShippingInfo();

    // TODO: 17/2/6

    return model;
  }
}
