package io.reactivesw.order.cart.application.service.update

import io.reactivesw.order.cart.application.model.action.SetTaxMode
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.infrastructure.enums.TaxMode
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class SetTaxModeServiceTest extends Specification {

    SetTaxModeService service

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    SetTaxMode setTaxMode

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version,)

        setTaxMode = new SetTaxMode(taxMode: TaxMode.Platform)

        service = new SetTaxModeService()
    }

    def "Test 1.1: set tax mode"() {

        when:
        service.handle(cartEntity, setTaxMode)
        then:
        noExceptionThrown()

    }
}