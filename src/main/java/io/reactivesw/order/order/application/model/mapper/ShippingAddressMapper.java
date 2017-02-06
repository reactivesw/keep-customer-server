package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.customer.customer.application.model.Address;
import io.reactivesw.order.order.domain.entity.value.ShippingAddressValue;

/**
 * Created by Davis on 17/2/6.
 */
public final class ShippingAddressMapper {
  /**
   * Instantiates a new Shipping address mapper.
   */
  private ShippingAddressMapper() {
  }

  
  /**
   * Model to entity shipping address value.
   *
   * @param model the model
   * @return the shipping address value
   */
  public static ShippingAddressValue modelToEntity(Address model) {
    ShippingAddressValue entity = new ShippingAddressValue();

    // TODO: 17/2/6
    
    return entity;
  }
}
