package io.reactivesw.authentication.application.service

import io.reactivesw.common.util.ServiceLocator
import io.reactivesw.customer.customer.application.model.Customer
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/21.
 */
class RestClientTest extends Specification {

    RestClient RestClient

    RestTemplate restTemplate = Mock(RestTemplate)

    ServiceLocator serviceLocator;

    Customer customer

    def email = "test@test.com"

    def password = "password"

    def gToken = "tmpGoogleToken"

    def setup() {
        serviceLocator = new ServiceLocator()
        RestClient = new RestClient(restTemplate: restTemplate, serviceLocator: serviceLocator)
        customer = new Customer()
    }

    def "Test 1.1: get customer by email"() {

        when:
        restTemplate.getForObject(_, _) >> customer
        Customer result = RestClient.getCustomerByEmail(email)
        then:
        customer == result
        noExceptionThrown()
    }

    def "Test 1.2: get customer by google token"() {

        when:
        restTemplate.getForObject(_, _) >> customer
        Customer result = RestClient.getCustomerByGoogleToken(gToken)
        then:
        customer == result
        noExceptionThrown()
    }

    def "Test 1.3: create customer with email"() {

        when:
        restTemplate.getForObject(_, _) >> customer
        Customer result = RestClient.createCustomerByEmail(email, password)
        then:
        customer == result
        noExceptionThrown()
    }
}
