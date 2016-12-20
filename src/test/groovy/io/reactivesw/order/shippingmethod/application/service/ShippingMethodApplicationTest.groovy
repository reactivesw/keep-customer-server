package io.reactivesw.order.shippingmethod.application.service

import io.reactivesw.order.shippingmethod.application.ShippingMethodApplication
import io.reactivesw.order.shippingmethod.domain.service.ShippingMethodService
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/20.
 */
class ShippingMethodApplicationTest extends Specification {

    ShippingMethodApplication application

    ShippingMethodService service = Mock(ShippingMethodService)

    def setup() {
        application = new ShippingMethodApplication(service: service)
    }

    def "Test 1.1: get shipping method by country, state, currency"() {
        when:
        application.getByLocation("", "", "")
        then:
        noExceptionThrown()
    }
}
