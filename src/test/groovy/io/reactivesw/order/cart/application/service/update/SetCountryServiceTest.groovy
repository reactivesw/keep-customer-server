package io.reactivesw.order.cart.application.service.update

import io.reactivesw.order.cart.application.model.action.SetCountry
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification


/**
 * Created by umasuo on 16/12/19.
 */
class SetCountryServiceTest extends Specification {

    SetCountryService service

    def country = "CN"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetCountry setCountry

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version, country: country)

        setCountry = new SetCountry(country: country)

        service = new SetCountryService()
    }

    def "Test 1.1: set the country"() {
        when:
        service.handle(cartEntity, setCountry)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: unset the country "() {
        setCountry.setCountry(null)
        when:
        service.handle(cartEntity, setCountry)
        then:
        noExceptionThrown()
    }
}
