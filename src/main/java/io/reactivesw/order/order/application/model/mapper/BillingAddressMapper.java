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
    entity.setTitle(null);
    entity.setSalutation(null);
    entity.setFirstName(null);
    entity.setLastName(null);
    entity.setStreetName(null);
    entity.setStreetNumber(null);
    entity.setAdditionalStreetInfo(null);
    entity.setPostalCode(null);
    entity.setCity(null);
    entity.setRegion(null);
    entity.setState(null);
    entity.setCountry(null);
    entity.setCompany(null);
    entity.setDepartment(null);
    entity.setBuilding(null);
    entity.setApartment(null);
    entity.setBox(null);
    entity.setMobile(null);
    entity.setEmail(null);
    entity.setFax(null);
    entity.setAdditionalAddressInfo(null);
    entity.setExternalId(null);

    return entity;
  }
}
