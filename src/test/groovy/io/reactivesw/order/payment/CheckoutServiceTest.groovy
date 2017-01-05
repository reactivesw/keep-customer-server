package io.reactivesw.order.payment

import com.braintreegateway.BraintreeGateway
import com.braintreegateway.ClientTokenGateway
import com.braintreegateway.Result
import com.braintreegateway.Transaction
import com.braintreegateway.TransactionGateway
import io.reactivesw.order.payment.domain.service.CheckoutService
import spock.lang.Specification

/**
 * Created by Davis on 17/1/5.
 */
class CheckoutServiceTest extends Specification {
    ClientTokenGateway clientTokenGateway = Mock()
    BraintreeGateway gateway = Mock(clientTokenGateway: clientTokenGateway, transactionGateway: transactionGateway)
    CheckoutService checkoutService = new CheckoutService(gateway: gateway)
    TransactionGateway transactionGateway = Mock()

    def "test 1 : get client token"() {
        given:
        String clientToken = "dlkfhsdkjhsfhjsdkfhskdfjslkdfhskd"
        clientTokenGateway.generate() >> clientToken
        gateway.clientToken() >> clientTokenGateway

        when:
        def result = checkoutService.getClientToken()

        then:
        result == clientToken
    }

    def "test 2 : checkout"() {
        given:
        String amount = "12.34"
        Result<Transaction> transactionResult = new Result<>()
        Transaction transaction = Mock()
        transactionResult.transaction = transaction
        String nonce = "sdlkjfdskfoiylcnvlkshdjkfsd"
        gateway.transaction() >> transactionGateway
        transactionGateway.sale(_) >> transactionResult

        when:
        def result = checkoutService.checkout(amount, nonce)

        then:
        result != null
    }

    def "test 3 : get transaction by id"() {
        given:
        String transactionId = "slkdhfkjsdhf"
        Transaction transaction = Mock()
        gateway.transaction() >> transactionGateway
        transactionGateway.find(_) >> transaction

        when:
        def result = checkoutService.getTransactionById(transactionId)

        then:
        result != null
    }
}
