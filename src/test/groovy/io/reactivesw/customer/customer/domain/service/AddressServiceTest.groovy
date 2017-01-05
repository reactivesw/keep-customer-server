package io.reactivesw.customer.customer.domain.service

import io.reactivesw.common.exception.NotExistException
import io.reactivesw.customer.customer.domain.entity.AddressValue
import io.reactivesw.customer.customer.domain.entity.CustomerEntity
import io.reactivesw.customer.customer.infrastructure.repository.AddressRepository
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/5.
 */
class AddressServiceTest extends Specification {

    AddressRepository addressRepository = Mock(AddressRepository)

    CustomerService customerService = Mock(CustomerService)

    AddressService addressService

    AddressValue addressValue

    CustomerEntity customer

    def customerId = "tmpCustomerId"

    def addressId = "tmpAddressId"

    def country = "CN"

    def state = "SHENZHEN"

    def setup() {
        addressService = new AddressService(addressRepository: addressRepository, customerService: customerService)
        addressValue = new AddressValue(id: addressId, country: country, state: state)

        Set<AddressValue> addresses = new HashSet<>()
        addresses.add(addressValue)

        customer = new CustomerEntity(addresses: addresses)
    }

    def "Test 1.1: get address by id"() {
        when:
        addressRepository.findOne(_) >> addressValue
        AddressValue result = addressService.getById(addressId)
        then:
        result != null
    }

    def "Test 1.2: get address by id that do not exist"() {
        when:
        addressRepository.findOne(_) >> null
        addressService.getById(addressId)
        then:
        thrown(NotExistException)
    }

    def "Test 2.1: get all addresses by customer id"() {
        when:
        customerService.getById(_) >> customer
        Set<AddressValue> result = addressService.getAllAddressByCustomerId(customerId)
        then:
        result != null
        result.size() == 1
    }

    def "Test 2.2: get all addresses by customer id who do not have address"() {
        customer.addresses = null
        when:
        customerService.getById(_) >> customer
        Set<AddressValue> result = addressService.getAllAddressByCustomerId(customerId)
        then:
        result != null
        result.size() == 0
    }
}
