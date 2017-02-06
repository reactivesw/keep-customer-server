package io.reactivesw.order.payment.domain.service;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.google.api.client.util.Lists;

import io.reactivesw.order.payment.application.model.CreditCard;
import io.reactivesw.order.payment.application.model.Payment;
import io.reactivesw.order.payment.application.model.action.AddCreditCardAction;
import io.reactivesw.order.payment.application.model.mapper.CreditCardMapper;
import io.reactivesw.order.payment.application.model.mapper.CustomerRequestMapper;
import io.reactivesw.order.payment.application.model.mapper.PaymentMapper;
import io.reactivesw.order.payment.application.model.mapper.TransactionRequestMapper;
import io.reactivesw.order.payment.domain.entity.PaymentEntity;
import io.reactivesw.order.payment.infrastructure.repository.PaymentRepository;

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
   * payment repository.
   */
  @Autowired
  private transient PaymentRepository paymentRepository;

  /**
   * get credit cards by customer id.
   *
   * @param customerId customer id
   * @return list of credit card
   */
  public List<CreditCard> getCreditCards(String customerId) {
    LOG.debug("enter getCreditCards, customer id is : {}", customerId);
    List<CreditCard> result = Lists.newArrayList();
    Customer customer = gateway.customer().find(restClient.getBraintreeCustomerId(customerId));
    if (customer == null) {
      LOG.debug("can not find customer by id : {}", customerId);
    } else if (customer.getCreditCards() == null) {
      LOG.debug("customer's credit card is null, customer id is : {}", customerId);
    } else {
      result = CreditCardMapper.entityToModel(customer.getCreditCards());
    }
    LOG.debug("end getCreditCards, get result : {}", result);
    return result;
  }

  /**
   * add credit card.
   *
   * @param addCreditCartAction update action
   * @return list of credit cards
   */
  public List<CreditCard> addCreditCard(String customerId,
                                        AddCreditCardAction addCreditCartAction) {

    LOG.debug("enter addCreditCard, customer id is : {}, credit card is : {}", customerId,
        addCreditCartAction.getCreditCart());
    String braintreeCustomerId = restClient.getBraintreeCustomerId(customerId);

    CustomerRequest request = CustomerRequestMapper.of(addCreditCartAction.getCreditCart());
    Result<Customer> result = null;
    if (StringUtils.isBlank(braintreeCustomerId)) {
      result = gateway.customer().create(request);
      restClient.saveBraintreeCustomerId(customerId, result.getTarget()
          .getId());
    } else {
      result = gateway.customer().update(braintreeCustomerId, request);
    }

    LOG.debug("end addCreditCard");

    return CreditCardMapper.entityToModel(result.getTarget().getCreditCards());
  }

  /**
   * checkout.
   *
   * @param amount amount to paid
   * @param token         payment method token
   * @return Transaction
   */
  public Payment checkout(String customerId, String amount, String token) {

    LOG.debug("enter checkout, amount is : {}, payment method token is : {}", amount, token);

    BigDecimal decimalAmount = null;
    try {
      decimalAmount = new BigDecimal(amount);
    } catch (NumberFormatException e) {
      LOG.debug("can not parse amount : {} to BigDecimal", amount);
    }

    TransactionRequest request = TransactionRequestMapper.of(decimalAmount, token);
    Result<Transaction> result = gateway.transaction().sale(request);

    // TODO: 17/2/4 处理不同的结果
    
    Transaction transaction = result.getTransaction();
    PaymentEntity entity = PaymentMapper.of(customerId, transaction);
    PaymentEntity savedEntity = paymentRepository.save(entity);

    return PaymentMapper.entityToModel(savedEntity);
  }
}
