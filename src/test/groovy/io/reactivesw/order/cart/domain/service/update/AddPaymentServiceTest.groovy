package io.reactivesw.order.cart.domain.service.update

import io.reactivesw.order.cart.application.model.action.AddDiscountCode
import io.reactivesw.order.cart.application.model.action.AddPayment
import io.reactivesw.order.cart.domain.entity.CartEntity
import spock.lang.Specification

/**
 * Created by umasuo on 16/12/19.
 */
class AddPaymentServiceTest extends Specification {

    AddPaymentService service

    def payment = "tmpPaymentId"


    def cartId = "tmpCartId"

    def version = 1

    CartEntity cartEntity

    AddPayment addPayment

    def setup() {

        cartEntity = new CartEntity(id: cartId, version: version,)

        addPayment = new AddPayment(payment: payment)

        service = new AddPaymentService()
    }

    def "Test 1.1: add payment"() {
        when:
        service.handle(cartEntity, addPayment)
        then:
        noExceptionThrown()
    }

    def "Test 1.2: add payment that already exist"() {
        List<String> payments = new ArrayList<>()
        payments.add(payment)
        cartEntity.setPaymentInfo(payments)
        when:
        service.handle(cartEntity, addPayment)
        then:
        noExceptionThrown()
    }
}
