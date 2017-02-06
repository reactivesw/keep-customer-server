package io.reactivesw.customer.customer.domain.service;

import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.customer.customer.domain.entity.AddressValue;
import io.reactivesw.customer.customer.domain.entity.CustomerEntity;
import io.reactivesw.customer.customer.infrastructure.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by umasuo on 17/1/5.
 */
@Service
public class AddressService {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(AddressService.class);

  /**
   * address repository.
   */
  @Autowired
  private transient AddressRepository addressRepository;

  /**
   * address repository.
   */
  @Autowired
  private transient CustomerService customerService;

  /**
   * get address by id.
   *
   * @param id String
   * @return AddressValue
   */
  public AddressValue getById(String id) {
    LOG.debug("enter: id: {}", id);

    AddressValue address = addressRepository.findOne(id);
    if (address == null) {
      throw new NotExistException("Address not exist for id: " + id);
    }

    LOG.debug("exit: address: {}", address);
    return address;
  }

  /**
   * get all the addresses for one customer.
   *
   * @param customerId customer id
   * @return A set of Address value
   */
  public Set<AddressValue> getAllAddressByCustomerId(String customerId) {
    LOG.debug("enter: subjectId: {}", customerId);

    CustomerEntity customer = customerService.getById(customerId);
    Set<AddressValue> addresses = customer.getAddresses();
    if (addresses == null) {
      addresses = new HashSet<>();
    }

    LOG.debug("exit: addresses: {}", addresses);
    return addresses;
  }
}
