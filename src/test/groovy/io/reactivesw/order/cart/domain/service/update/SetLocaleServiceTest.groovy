package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.order.cart.application.model.action.SetLocale
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/20.
 */
class SetLocaleServiceTest extends Specification {


    SetLocaleService service

    def locale = "tmpLocale"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetLocale setLocale

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version,)

        setLocale = new SetLocale(locale: locale)

        service = new SetLocaleService()
    }

    def "Test 1.1: set cart locale"() {

        when:
        service.handle(cartEntity, setLocale)
        then:
        noExceptionThrown()
    }
}
