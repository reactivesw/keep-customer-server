package io.reactivesw.authentication.application.service

import io.reactivesw.common.util.ServiceLocator
import io.reactivesw.customer.customer.application.model.Customer
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/21.
 */
class LoginRestClientTest extends Specification {

    LoginRestClient loginRestClient

    RestTemplate restTemplate = Mock(RestTemplate)

    ServiceLocator serviceLocator;

    Customer customer

    def email = "test@test.com"

    def gToken = "tmpGoogleToken"

    def setup() {
        serviceLocator = new ServiceLocator()
        loginRestClient = new LoginRestClient(restTemplate: restTemplate, serviceLocator: serviceLocator)
        customer = new Customer()
    }

    def "Test 1.1: get customer by email"() {

        when:
        restTemplate.getForObject(_, _) >> customer
        Customer result = loginRestClient.getCustomerByEmail(email)
        then:
        customer == result
        noExceptionThrown()
    }

    def "Test 1.2: get customer by google token"() {

        when:
        restTemplate.getForObject(_, _) >> customer
        Customer result = loginRestClient.getCustomerByGoogleToken(gToken)
        then:
        customer == result
        noExceptionThrown()
    }
}
