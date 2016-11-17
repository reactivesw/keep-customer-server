package io.reactivesw.customer.server.customer.service


import spock.lang.Specification

import io.reactivesw.customer.server.customer.models.draft.CustomerDraft

/**
 * Created by BruceLiu on 16/11/16.
 */
class CustomerServiceTest extends Specification {
    CustomerRepository customerRepository = Mock()
    CustomerService customerService = new CustomerService(customerRepository: customerRepository)

    def "test create an new customer"() {
        def customerDraft = new CustomerDraft()
        customerDraft.setEmail("liuquan@gmail.com")
        customerDraft.setPassword("password")
        def customerEntity = new CustomerEntity()

        given:
        customerRepository.save(_) >> customerEntity

        when:
        def savedCustomer = customerService.createCustomer(customerDraft)

        then:
        savedCustomer != null
    }

}
