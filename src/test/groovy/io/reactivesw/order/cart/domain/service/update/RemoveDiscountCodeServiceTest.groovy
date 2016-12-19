package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.exception.NotExistException
import io.reactivesw.order.cart.application.model.action.AddDiscountCode
import io.reactivesw.order.cart.application.model.action.RemoveDiscountCode
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class RemoveDiscountCodeServiceTest extends Specification {

    RemoveDiscountCodeService service

    def discountCode = "tmpDiscountCode"


    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    RemoveDiscountCode removeDiscountCode

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version,)

        removeDiscountCode = new RemoveDiscountCode(code: discountCode)

        service = new RemoveDiscountCodeService()
    }

    def "Test 1.1: remove discount code"() {

        when:
        service.handle(cartEntity, removeDiscountCode)
        then:
        thrown(NotExistException)
    }

    def "Test 1.2: remove discount code"() {

        List<String> codes = new ArrayList<>()
        codes.add("fakeDiscountCode")
        cartEntity.setDiscountCodes(codes)
        when:
        service.handle(cartEntity, removeDiscountCode)
        then:
        thrown(NotExistException)
    }

    def "Test 1.3: add discount code with exist discount codes"() {

        List<String> codes = new ArrayList<>()
        codes.add(discountCode)
        cartEntity.setDiscountCodes(codes)
        when:
        service.handle(cartEntity, removeDiscountCode)
        then:
        noExceptionThrown()
    }
}
