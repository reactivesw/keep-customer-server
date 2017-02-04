package io.reactivesw.order.payment.application.controller;

import com.braintreegateway.Transaction;

import io.reactivesw.order.payment.application.model.CreditCard;
import io.reactivesw.order.payment.application.model.action.AddCreditCardAction;
import io.reactivesw.order.payment.domain.service.PaymentService;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

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
   * payment service.
   */
  @Autowired
  private transient PaymentService paymentService;

  /**
   * get credit cards by customer id.
   * @param customerId customer id
   * @return list of credit cards
   */
  @ApiOperation("get credit carts by customer id")
  @GetMapping("/credit-cards")
  public List<CreditCard> getCreditCards(@RequestParam String customerId) {
    LOG.debug("enter getCreditCards, customer id is : {}", customerId);
    List<CreditCard> result = paymentService.getCreditCards(customerId);
    LOG.debug("end getCreditCards, result size is : {}", result.size());
    return result;
  }

  /**
   * update customer payment method.
   * @param addCreditCardAction update action
   * @return list of credit cards
   */
  @ApiOperation("update customer credit cart")
  @PutMapping("/credit-cart")
  public List<CreditCard> addCreditCard(AddCreditCardAction addCreditCardAction) {
    LOG.debug("enter addCreditCard");

    List<CreditCard> result = paymentService.addCreditCard(addCreditCardAction);

    LOG.debug("end addCreditCard");

    return result;
  }

  /**
   * checkout.
   * @param amount amount to paid
   * @param token payment method token
   * @return transaction
   */
  @ApiOperation("checkout")
  @PostMapping("/payment")
  public Transaction checkout(@RequestParam String amount, @RequestParam
      String token) {
    LOG.debug("enter checkout, amount is : {}, token is : {}", amount, token);
    BigDecimal decimalAmount = null;
    try {
      decimalAmount = new BigDecimal(amount);
    } catch (NumberFormatException e) {
      LOG.debug("some thing wrong");
    }
    Transaction result = paymentService.checkout(decimalAmount, token);
    LOG.debug("end checkout, result is : {}", result);
    return result;
  }
}
