package io.reactivesw.order.payment

import com.braintreegateway.BraintreeGateway
import com.braintreegateway.ClientTokenGateway
import com.braintreegateway.CreditCard
import com.braintreegateway.Customer
import com.braintreegateway.CustomerGateway
import com.braintreegateway.Result
import com.braintreegateway.Transaction
import com.braintreegateway.TransactionGateway
import com.google.api.client.util.Lists
import io.reactivesw.order.payment.domain.service.PaymentRestClient
import io.reactivesw.order.payment.domain.service.PaymentService
import spock.lang.Specification

/**
 * Created by Davis on 17/1/5.
 */
class PaymentServiceTest extends Specification {
    ClientTokenGateway clientTokenGateway = Mock()
    BraintreeGateway gateway = Mock()
    PaymentRestClient restClient = Mock()
    PaymentService paymentService = new PaymentService(gateway: gateway, restClient: restClient)
    TransactionGateway transactionGateway = Mock()

    def "test 1 : get credit carts"() {
//        given:
//        String customerId = "customerId"
//        String braintreeCustomerId = "sdfljksdf"
//        Customer customer = Mock()
//        CreditCard creditCard = Mock()
//        creditCard.getLast4() >> "1111"
//        restClient.getBraintreeCustomerId(_) >> braintreeCustomerId
//        CustomerGateway customerGateway = Mock()
//        gateway.customer() >> customerGateway
//        customerGateway.find(_) >> customer
//        List<CreditCard> creditCards = Mock()
//        customer.getCreditCards() >> creditCards
//
//        when:
////        def result = paymentService.getCreditCards(customerId)
//        println(creditCard.getLast4())
//
//        then:
////        result != null
//        true
    }

    def "test 3 : checkout"() {
//        given:
//        String amount = "12.34"
//        Result<Transaction> transactionResult = new Result<>()
//        Transaction transaction = Mock()
//        transactionResult.target = transaction
//        String nonce = "sdlkjfdskfoiylcnvlkshdjkfsd"
//        transactionGateway.sale(_) >> transactionResult
//        gateway.transaction() >> transactionGateway
//
//        when:
//        def result = paymentService.checkout(amount, nonce)
//
//        then:
//        result != null
    }
}
