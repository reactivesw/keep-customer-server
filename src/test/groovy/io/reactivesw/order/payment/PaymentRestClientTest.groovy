package io.reactivesw.order.payment

import io.reactivesw.order.payment.domain.service.PaymentRestClient
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Created by Davis on 17/2/4.
 */
class PaymentRestClientTest extends Specification {
    RestTemplate restTemplate = Mock()
    PaymentRestClient restClient = new PaymentRestClient(restTemplate: restTemplate)

    def "test 1 : get braintree customer id"() {
        given:
        String customerId = "sdfdfdfs"
        String paymentAccountId = "sdkkkdhfd"
        restTemplate.getForObject(_, _) >> paymentAccountId

        when:
        def result = restClient.getPaymentAccountId(customerId)

        then:
        result == paymentAccountId
    }

    def "test 2 : save braintree customer id"() {
        given:
        String customreId = "skdfjldshf"
        String btCustomerId = "slkdhfkjd"

        when:
        restClient.savePaymentAccountId(customreId, btCustomerId)

        then:
        true
    }
}
