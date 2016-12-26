package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.common.model.Address;
import io.reactivesw.order.cart.domain.entity.value.BillingAddressValue;
import io.reactivesw.order.cart.domain.entity.value.ShippingAddressValue;

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
  public static Address entityToModel(BillingAddressValue entity) {
    Address address = null;
    if (entity != null) {
      address = new Address();
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
    }
    return address;
  }

  /**
   * convert entity to model.
   *
   * @param entity BillingAddressValue
   * @return Address
   */
  public static Address entityToModel(ShippingAddressValue entity) {
    Address address = null;
    if (entity != null) {
      address = new Address();
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
    }
    return address;
  }

  /**
   * convert model to shipping address.
   *
   * @return ShippingAddressValue
   */
  public static ShippingAddressValue modelToShippingAddress(Address address) {
    ShippingAddressValue value = new ShippingAddressValue();

    value.setTitle(address.getTitle());

    value.setSalutation(address.getSalutation());

    value.setFirstName(address.getFirstName());

    value.setLastName(address.getLastName());

    value.setStreetName(address.getStreetName());

    value.setStreetNumber(address.getStreetNumber());

    value.setAdditionalStreetInfo(address.getAdditionalStreetInfo());

    value.setPostalCode(address.getPostalCode());

    value.setCity(address.getCity());

    value.setRegion(address.getRegion());

    value.setState(address.getState());

    value.setCountry(address.getCountry());

    value.setCompany(address.getCompany());

    value.setDepartment(address.getDepartment());

    value.setBuilding(address.getBuilding());

    value.setApartment(address.getApartment());

    value.setBox(address.getpOBox());

    value.setPhone(address.getPhone());

    value.setMobile(address.getMobile());

    value.setEmail(address.getEmail());

    value.setFax(address.getFax());

    value.setAdditionalAddressInfo(address.getAdditionalAddressInfo());

    value.setExternalId(address.getExternalId());

    return value;
  }

  /**
   * convert model to billing address.
   *
   * @return BillingAddressValue
   */
  public static BillingAddressValue modelToBillingAddress(Address address) {
    BillingAddressValue value = new BillingAddressValue();

    value.setTitle(address.getTitle());

    value.setSalutation(address.getSalutation());

    value.setFirstName(address.getFirstName());

    value.setLastName(address.getLastName());

    value.setStreetName(address.getStreetName());

    value.setStreetNumber(address.getStreetNumber());

    value.setAdditionalStreetInfo(address.getAdditionalStreetInfo());

    value.setPostalCode(address.getPostalCode());

    value.setCity(address.getCity());

    value.setRegion(address.getRegion());

    value.setState(address.getState());

    value.setCountry(address.getCountry());

    value.setCompany(address.getCompany());

    value.setDepartment(address.getDepartment());

    value.setBuilding(address.getBuilding());

    value.setApartment(address.getApartment());

    value.setBox(address.getpOBox());

    value.setPhone(address.getPhone());

    value.setMobile(address.getMobile());

    value.setEmail(address.getEmail());

    value.setFax(address.getFax());

    value.setAdditionalAddressInfo(address.getAdditionalAddressInfo());

    value.setExternalId(address.getExternalId());

    return value;
  }


}
