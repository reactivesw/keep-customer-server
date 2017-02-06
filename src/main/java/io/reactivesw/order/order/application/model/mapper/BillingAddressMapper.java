package io.reactivesw.order.order.application.model.mapper;

import io.reactivesw.customer.customer.application.model.Address;
import io.reactivesw.order.order.domain.entity.value.BillingAddressValue;

/**
 * Created by Davis on 17/2/6.
 */
public final class BillingAddressMapper {
  /**
   * Instantiates a new Billing address mapper.
   */
  private BillingAddressMapper() {
  }

  /**
   * Model to entity billing address value.
   *
   * @param model the model
   * @return the billing address value
   */
  public static BillingAddressValue modelToEntity(Address model) {
    BillingAddressValue entity = new BillingAddressValue();

    // TODO: 17/2/6

    return entity;
  }
}
