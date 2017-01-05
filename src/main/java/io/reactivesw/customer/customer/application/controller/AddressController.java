package io.reactivesw.customer.customer.application.controller;

import io.reactivesw.customer.customer.application.model.Address;
import io.reactivesw.customer.customer.application.model.mapper.AddressMapper;
import io.reactivesw.customer.customer.domain.entity.AddressValue;
import io.reactivesw.customer.customer.domain.service.AddressService;
import io.reactivesw.route.CustomerRouter;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 16/12/27.
 */
@RestController
public class AddressController {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(AddressController.class);

  /**
   * address service.
   */
  @Autowired
  private transient AddressService addressService;

  /**
   *
   * @param addressId
   * @return
   */
  @ApiOperation(value = "get address by address id")
  @GetMapping(CustomerRouter.ADDRESS_WITH_ID)
  public Address getAddressById(@PathVariable String addressId) {
    LOG.debug("enter: addressId: {}", addressId);

    AddressValue addressValue = addressService.getById(addressId);
    Address address = AddressMapper.entityToModel(addressValue);

    LOG.debug("exit: address: {}", address);
    return address;
  }

}
