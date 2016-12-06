package io.reactivesw.orders.carts.applications.models.mapper;

import io.reactivesw.common.models.Address;
import io.reactivesw.orders.carts.domains.entities.values.BillingAddressValue;

/**
 * Created by umasuo on 16/12/5.
 */
public class AddressMapper {

  /**
   * convert entity to model.
   *
   * @param entity BillingAddressValue
   * @return Address
   */
  public static Address convertEntityToModel(BillingAddressValue entity) {
    Address address = new Address();
    address.setId(entity.getId());

    address.setTitle(entity.getTitle());

    address.setSalutation(entity.getSalutation());

    address.setFirstName(entity.getFirstName());

    address.setLastName(entity.getLastName());

    address.setStreetName(entity.getStreetName());

    address.setStreetNumber(entity.getStreetNumber());

    address.setAdditionalStreetInfo(entity.getAdditionalStreetInfo());

    address.setPostalCode(entity.getPostalCode());

    address.setCity(entity.getCity());

    address.setRegion(entity.getRegion());

    address.setState(entity.getState());

    address.setCountry(entity.getCountry());

    address.setCompany(entity.getCompany());

    address.setDepartment(entity.getDepartment());

    address.setBuilding(entity.getBuilding());

    address.setApartment(entity.getApartment());

    address.setpOBox(entity.getBox());

    address.setPhone(entity.getPhone());

    address.setMobile(entity.getMobile());

    address.setEmail(entity.getEmail());

    address.setFax(entity.getFax());

    address.setAdditionalAddressInfo(entity.getAdditionalAddressInfo());

    address.setExternalId(entity.getExternalId());
    return address;
  }
}
