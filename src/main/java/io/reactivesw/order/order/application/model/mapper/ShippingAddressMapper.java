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

    if (model != null) {
      entity.setTitle(model.getTitle());
      entity.setSalutation(model.getSalutation());
      entity.setFirstName(model.getFirstName());
      entity.setLastName(model.getLastName());
      entity.setStreetName(model.getStreetName());
      entity.setStreetNumber(model.getStreetNumber());
      entity.setAdditionalStreetInfo(model.getAdditionalStreetInfo());
      entity.setPostalCode(model.getPostalCode());
      entity.setCity(model.getCity());
      entity.setRegion(model.getRegion());
      entity.setState(model.getState());
      entity.setCountry(model.getCountry());
      entity.setCompany(model.getCompany());
      entity.setDepartment(model.getDepartment());
      entity.setBuilding(model.getBuilding());
      entity.setApartment(model.getApartment());
      entity.setBox(model.getPOBox());
      entity.setPhone(model.getPhone());
      entity.setMobile(model.getMobile());
      entity.setEmail(model.getEmail());
      entity.setFax(model.getFax());
      entity.setAdditionalAddressInfo(model.getAdditionalAddressInfo());
      entity.setExternalId(model.getExternalId());
    }
    
    return entity;
  }
}
