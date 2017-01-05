package io.reactivesw.order.payment.application.controller;

import com.braintreegateway.Transaction;

import io.reactivesw.order.payment.application.model.TransactionModel;
import io.reactivesw.order.payment.application.model.mapper.TransactionMapper;
import io.reactivesw.order.payment.domain.service.CheckoutService;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Davis on 17/1/4.
 */
@RestController
public class PaymentController {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

  /**
   * checkout service.
   */
  @Autowired
  private transient CheckoutService checkoutService;

  /**
   * Gets client token.
   *
   * @return the client token
   */
  @ApiOperation("get braintree client token")
  @GetMapping("/payments/client-token")
  public String getClientToken() {
    LOG.debug("enter getClientToken");
    String clientToken = checkoutService.getClientToken();
    LOG.debug("end getClientToken, client token is : {}", clientToken);
    return clientToken;
  }

  /**
   * Checkout result.
   *
   * @param amount the amount
   * @param nonce  the nonce
   * @return the result
   */
  @ApiOperation("checkout")
  @PostMapping("/payments")
  public TransactionModel checkout(String amount, String nonce) {
    LOG.debug("enter checkout, amount is : {}, nonce is : {}", amount, nonce);

    Transaction result = checkoutService.checkout(amount, nonce);

    LOG.debug("end checkout, result is : {}", result.toString());

    return TransactionMapper.entityToModel(result);
  }

  /**
   * Gets transaction.
   *
   * @param transactionId the transaction id
   * @return the transaction
   */
  @ApiOperation("get transaction by id")
  @GetMapping("/payments/{transactionId}")
  public TransactionModel getTransaction(String transactionId) {
    LOG.debug("enter getTransaction, id is : {}", transactionId);

    Transaction result = checkoutService.getTransactionById(transactionId);

    LOG.debug("end getTransaction, get result : {}", result.toString());

    return TransactionMapper.entityToModel(result);
  }
}
