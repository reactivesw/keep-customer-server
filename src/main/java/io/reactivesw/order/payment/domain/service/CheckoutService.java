package io.reactivesw.order.payment.domain.service;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Davis on 16/12/27.
 */
@Service
public class CheckoutService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CheckoutService.class);

  /**
   * braintree gateway.
   */
  @Autowired
  private transient BraintreeGateway gateway;

  /**
   * Gets client token.
   *
   * @return the client token
   */
  public String getClientToken() {
    LOG.debug("enter getClientToken");
    String clientToken = gateway.clientToken().generate();
    LOG.debug("end getClientToken, get token : {}", clientToken);
    return clientToken;
  }

  /**
   * Checkout result.
   *
   * @param amount the decimal amount
   * @param nonce         the nonce
   * @return the result
   */
  public Transaction checkout(String amount, String nonce) {
    LOG.debug("enter checkout, amount is : {}, nonce is : {}", amount, nonce);

    BigDecimal decimalAmount = new BigDecimal(amount);

    TransactionRequest request = new TransactionRequest()
        .amount(decimalAmount)
        .paymentMethodNonce(nonce)
        .options()
        .submitForSettlement(true)
        .done();

    Result<Transaction> result = gateway.transaction().sale(request);

    LOG.debug("end checkout, result is : {}", result.getMessage());

    return result.getTransaction();
  }

  /**
   * Gets transaction by id.
   *
   * @param transactionId the transaction id
   * @return the transaction by id
   */
  public Transaction getTransactionById(String transactionId) {
    LOG.debug("enter getTransaction, id is : {}", transactionId);

    Transaction transaction = gateway.transaction().find(transactionId);

    LOG.debug("end getTransaction, get transaction : {}", transaction.toString());

    return transaction;
  }
}
