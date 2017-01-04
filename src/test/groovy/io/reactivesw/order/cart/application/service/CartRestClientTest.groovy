package io.reactivesw.order.cart.application.service

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by umasuo on 17/1/4.
 */
class CartRestClientTest extends Specification {

    RestTemplate restTemplate = Mock(RestTemplate)

    CartRestClient cartRestClient

    def setup() {
        cartRestClient = new CartRestClient(restTemplate: restTemplate)
    }

    def "Test 1.1: Test get address"() {
        when:
        restTemplate.getForObject(_, _) >> null
        cartRestClient.getAddress("")
        then:
        noExceptionThrown()
    }

    def "Test 1.2: Test get product"() {
        when:
        restTemplate.getForObject(_, _) >> null
        cartRestClient.getProduct("")
        then:
        noExceptionThrown()
    }

    def "Test 1.3: Test get Zone"() {
        when:
        restTemplate.getForObject(_, _) >> null
        cartRestClient.getZone("")
        then:
        noExceptionThrown()
    }

    def "Test 1.4: Test get TaxCategory"() {
        when:
        restTemplate.getForObject(_, _) >> null
        cartRestClient.getTaxCategory("")
        then:
        noExceptionThrown()
    }

    def "Test 1.5: Test get ShippingMethod"() {
        when:
        restTemplate.getForObject(_, _) >> null
        cartRestClient.getShippingMethod("")
        then:
        noExceptionThrown()
    }
}
