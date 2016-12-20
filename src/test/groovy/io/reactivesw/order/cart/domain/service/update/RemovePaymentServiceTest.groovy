package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.common.exception.NotExistException
import io.reactivesw.order.cart.application.model.action.RemoveDiscountCode
import io.reactivesw.order.cart.application.model.action.RemovePayment
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class RemovePaymentServiceTest extends Specification {

    RemovePaymentService service

    def payment = "tmpPaymentId"

    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    RemovePayment removePayment

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version,)

        removePayment = new RemovePayment(payment: payment)

        service = new RemovePaymentService()
    }

    def "Test 1.1: remove payment"() {
        List<String> payments = new ArrayList<>()
        payments.add(payment)
        cartEntity.setPaymentInfo(payments)
        when:
        service.handle(cartEntity, removePayment)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: remove payment that not exist"() {
        List<String> payments = new ArrayList<>()
        payments.add(payment)
        cartEntity.setPaymentInfo(payments)
        removePayment.setPayment("fakePaymentId")
        when:
        service.handle(cartEntity, removePayment)
        then:
        thrown(NotExistException)
    }

    def "Test 1.3: remove payment that with null payments"() {
        cartEntity.setPaymentInfo(null)
        when:
        service.handle(cartEntity, removePayment)
        then:
        thrown(NotExistException)
    }
}
