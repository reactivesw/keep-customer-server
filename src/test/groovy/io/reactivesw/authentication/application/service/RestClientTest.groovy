package io.reactivesw.authentication.application.service

import io.reactivesw.authentication.infrastructure.util.JwtUtil
import io.reactivesw.common.util.ServiceLocator
import io.reactivesw.customer.customer.application.model.Customer
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/21.
 */
class RestClientTest extends Specification {

    RestClient restClient

    RestTemplate restTemplate = Mock(RestTemplate)

    ServiceLocator serviceLocator;

    JwtUtil jwtUtil;

    Customer customer

    def email = "test@test.com"

    def password = "password"

    def gToken = "tmpGoogleToken"

    def setup() {
        serviceLocator = new ServiceLocator()
        jwtUtil = new JwtUtil(secret: "QWERTYUIOP", expiresIn: 7200000)
        restClient = new RestClient(serviceLocator, jwtUtil)
        restClient.setRestTemplate(restTemplate)
        customer = new Customer(id: "id", customerName: "umasuo")
    }

    def "Test 1.1: get customer by email"() {

        when:
        restTemplate.getForObject(_, _) >> customer
        Customer result = restClient.getCustomerByEmail(email)
        then:
        customer == result
        noExceptionThrown()
    }

    def "Test 1.2: get customer by google token"() {
        ResponseEntity responseEntity = Mock(ResponseEntity)
        when:
        restTemplate.exchange(_, _, _, _) >> responseEntity
        responseEntity.getBody() >> customer
        Customer result = restClient.getCustomerByGoogleToken(gToken)
        then:
        customer == result
        noExceptionThrown()
    }

    def "Test 1.3: create customer with email"() {

        when:
        restTemplate.getForObject(_, _) >> customer
        Customer result = restClient.createCustomerByEmail(email, password)
        then:
        customer == result
        noExceptionThrown()
    }
}
