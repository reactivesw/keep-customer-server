package io.reactivesw.order.payment.domain.service;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.google.api.client.util.Lists;

import io.reactivesw.order.payment.application.model.CreditCard;
import io.reactivesw.order.payment.application.model.action.AddCreditCardAction;
import io.reactivesw.order.payment.application.model.mapper.CreditCardMapper;
import io.reactivesw.order.payment.application.model.mapper.CustomerRequestMapper;
import io.reactivesw.order.payment.application.model.mapper.TransactionRequestMapper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Davis on 16/12/27.
 */
@Service
public class PaymentService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);

  /**
   * braintree gateway.
   */
  @Autowired
  private transient BraintreeGateway gateway;

  /**
   * payment rest client, used to call customer server api.
   */
  @Autowired
  private transient PaymentRestClient restClient;

  /**
   * get credit cards by customer id.
   * @param customerId customer id
   * @return list of credit card
   */
  public List<CreditCard> getCreditCards(String customerId) {
    List<CreditCard> result = Lists.newArrayList();
    Customer customer = gateway.customer().find(restClient.getBraintreeCustomerId(customerId));
    if (customer == null) {
      LOG.debug("can not find customer by id : {}", customerId);
    } else if (customer.getCreditCards() == null) {
      LOG.debug("customer's credit card is null, customer id is : {}", customerId);
    } else {
      result = CreditCardMapper.entityToModel(customer.getCreditCards());
    }
    return result;
  }

  /**
   * add credit card.
   * @param addCreditCartAction update action
   * @return list of credit cards
   */
  public List<CreditCard> addCreditCard(AddCreditCardAction addCreditCartAction) {

    String braintreeCustomerId = restClient.getBraintreeCustomerId(addCreditCartAction
        .getCustomerId());

    CustomerRequest request = CustomerRequestMapper.of(addCreditCartAction.getCreditCart());
    Result<Customer> result = null;
    if (StringUtils.isBlank(braintreeCustomerId)) {
      result = gateway.customer().create(request);
      restClient.saveBraintreeCustomerId(addCreditCartAction.getCustomerId(), result.getTarget()
          .getId());
    } else {
      result = gateway.customer().update(braintreeCustomerId, request);
    }

    return CreditCardMapper.entityToModel(result.getTarget().getCreditCards());
  }

  /**
   * checkout.
   * @param decimalAmount amount to paid
   * @param token payment method token
   * @return Transaction
   */
  public Transaction checkout(BigDecimal decimalAmount, String token) {

    TransactionRequest request = TransactionRequestMapper.of(decimalAmount, token);
    Result<Transaction> result = gateway.transaction().sale(request);

    // TODO: 17/2/3 save transaction

    return result.getTarget();
  }
}
