package io.reactivesw.customer.customer.application.model.mapper;

import io.reactivesw.customer.customer.application.model.Address;
import io.reactivesw.customer.customer.domain.entity.AddressValue;

/**
 * Created by umasuo on 17/1/5.
 */
public class AddressMapper {

  /**
   * entity to model.
   *
   * @param entity AddressValue
   * @return Address
   */
  public static Address entityToModel(AddressValue entity) {
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

      address.setPOBox(entity.getBox());

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
   * model to entity.
   *
   * @param model Address
   * @return AddressValue
   */
  public AddressValue modelToEntity(Address model) {
    AddressValue address = null;
    if (model != null) {
      address = new AddressValue();
      address.setId(model.getId());

      address.setTitle(model.getTitle());

      address.setSalutation(model.getSalutation());

      address.setFirstName(model.getFirstName());

      address.setLastName(model.getLastName());

      address.setStreetName(model.getStreetName());

      address.setStreetNumber(model.getStreetNumber());

      address.setAdditionalStreetInfo(model.getAdditionalStreetInfo());

      address.setPostalCode(model.getPostalCode());

      address.setCity(model.getCity());

      address.setRegion(model.getRegion());

      address.setState(model.getState());

      address.setCountry(model.getCountry());

      address.setCompany(model.getCompany());

      address.setDepartment(model.getDepartment());

      address.setBuilding(model.getBuilding());

      address.setApartment(model.getApartment());

      address.setBox(model.getPOBox());

      address.setPhone(model.getPhone());

      address.setMobile(model.getMobile());

      address.setEmail(model.getEmail());

      address.setFax(model.getFax());

      address.setAdditionalAddressInfo(model.getAdditionalAddressInfo());

      address.setExternalId(model.getExternalId());

    }
    return address;
  }
}
