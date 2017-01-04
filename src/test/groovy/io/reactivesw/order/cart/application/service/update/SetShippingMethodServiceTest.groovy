package io.reactivesw.order.cart.application.service.update

import io.reactivesw.common.exception.ImmutableException
import io.reactivesw.common.model.Reference
import io.reactivesw.order.cart.application.model.action.SetShippingMethod
import io.reactivesw.order.cart.domain.entity.CartEntity
import io.reactivesw.order.cart.domain.entity.value.ShippingInfoValue
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class SetShippingMethodServiceTest extends Specification {

    SetShippingMethodService service

    def shippingInfoId = "tmpShippingInfoId"

    def cartId = "tmpCartId"

    def version = 1

    def shippingMethodId = "tmpShippingMethodId"

    def shippingMethodName = "MSN"

    def shippingAddressId = "tmpShippingAddressId"

    CartEntity cartEntity

    SetShippingMethod setShippingMethod

    ShippingInfoValue shippingInfoValue


    def setup() {

        shippingInfoValue = new ShippingInfoValue(id: shippingInfoId, shippingMethod: shippingMethodId)

        cartEntity = new CartEntity(id: cartId, version: version, shippingInfo: shippingInfoValue, shippingAddress: shippingAddressId)

        setShippingMethod = new SetShippingMethod(shippingMethod: new Reference(id: shippingInfoId))

        service = new SetShippingMethodService()

    }

    def "Test 1.1: set new shipping method"() {

        when:
        service.handle(cartEntity, setShippingMethod)
        then:
        noExceptionThrown()

    }

    def "Test 1.2: set new shipping method with null shipping address"() {
        cartEntity.setShippingAddress(null)
        when:
        service.handle(cartEntity, setShippingMethod)
        then:
        thrown(ImmutableException)
    }

    def "Test 1.3: unset shipping method"() {
        setShippingMethod.setShippingMethod(null)
        when:
        service.handle(cartEntity, setShippingMethod)
        then:
        noExceptionThrown()
    }

    def "Test 1.4: unset shipping method with shipping info not set"() {
        setShippingMethod.setShippingMethod(null)
        cartEntity.setShippingInfo(null)
        when:
        service.handle(cartEntity, setShippingMethod)
        then:
        noExceptionThrown()
    }
}
