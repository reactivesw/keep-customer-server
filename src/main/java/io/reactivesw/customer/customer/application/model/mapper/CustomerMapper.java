package io.reactivesw.customer.customer.application.model.mapper;

import io.reactivesw.common.model.Reference;
import io.reactivesw.customer.customer.application.model.Address;
import io.reactivesw.customer.customer.application.model.Customer;
import io.reactivesw.customer.customer.domain.entity.AddressValue;
import io.reactivesw.customer.customer.domain.entity.CustomerEntity;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by umasuo on 17/1/9.
 */
public class CustomerMapper {

  /**
   * entity to model.
   *
   * @param entity CustomerEntity
   * @return Customer
   */
  public static Customer entityToModel(CustomerEntity entity) {
    Customer model = null;
    if (entity != null) {
      model = new Customer();
      model.setId(entity.getId());
      model.setPassword(entity.getPassword());
      model.setCustomerName(entity.getCustomerName());
      model.setVersion(entity.getVersion());
      model.setEmail(entity.getEmail());
      model.setFirstName(entity.getFirstName());
      model.setLastName(entity.getLastName());
      model.setMiddleName(entity.getMiddleName());
      model.setTitle(entity.getTitle());
      model.setDateOfBirth(entity.getDateOfBirth());
      model.setCompanyName(entity.getCompanyName());
      model.setVatId(entity.getVatId());

      List<Address> addressList = new ArrayList<>();
      Set<AddressValue> addressValueSet = entity.getAddresses();
      if (addressValueSet != null) {
        addressValueSet.parallelStream().forEach(
            addressValue -> addressList.add(AddressMapper.entityToModel(addressValue))
        );
      }
      model.setAddresses(addressList);

      model.setDefaultShippingAddressId(entity.getDefaultShippingAddressId());
      model.setDefaultBillingAddressId(entity.getDefaultBillingAddressId());
      model.setIsEmailVerified(entity.getIsEmailVerified());
      model.setExternalId(entity.getExternalId());

      String customerGroupId = entity.getCustomerGroupId();
      if (customerGroupId != null) {
        Reference customerGroup = new Reference();
        model.setCustomerGroup(customerGroup);
      }

      model.setLocale(entity.getLocale());
    }

    return model;
  }

}
