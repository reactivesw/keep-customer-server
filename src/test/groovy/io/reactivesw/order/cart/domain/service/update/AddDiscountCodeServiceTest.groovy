package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.order.cart.application.model.action.AddDiscountCode
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class AddDiscountCodeServiceTest extends Specification {

    AddDiscountCodeService service

    def discountCode = "tmpDiscountCode"


    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    AddDiscountCode addDiscountCode

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version,)

        addDiscountCode = new AddDiscountCode(code: discountCode)

        service = new AddDiscountCodeService()

    }

    def "Test 1.1: add discount code"() {

        when:
        service.handle(cartEntity, addDiscountCode)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: add discount code with exist discount codes"() {

        List<String> codes = new ArrayList<>()
        codes.add(discountCode)
        cartEntity.setDiscountCodes(codes)
        when:
        service.handle(cartEntity, addDiscountCode)
        then:
        noExceptionThrown()
    }
}
