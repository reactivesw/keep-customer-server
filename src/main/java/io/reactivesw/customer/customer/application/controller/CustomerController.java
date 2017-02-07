package io.reactivesw.customer.customer.application.controller;

import io.reactivesw.common.model.UpdateRequest;
import io.reactivesw.customer.customer.application.model.Customer;
import io.reactivesw.customer.customer.application.model.SignupWithEmail;
import io.reactivesw.customer.customer.application.model.action.CustomerUpdateAction;
import io.reactivesw.customer.customer.application.model.mapper.CustomerMapper;
import io.reactivesw.customer.customer.application.service.CustomerApplication;
import io.reactivesw.customer.customer.domain.entity.CustomerEntity;
import io.reactivesw.customer.customer.domain.service.CustomerService;
import io.reactivesw.route.CustomerRouter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 16/12/27.
 */
@RestController
public class CustomerController {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(CustomerController.class);

  /**
   * customer service.
   */
  @Autowired
  private transient CustomerService customerService;

  /**
   * customer service.
   */
  @Autowired
  private transient CustomerApplication customerApplication;

  /**
   * EXIT LOGGER INFO.
   */
  private static final String EXIT_LOG_INFO = "exit: customer: {}";

  /**
   * login with email.
   *
   * @param email String
   * @return Customer
   */
  @GetMapping(value = CustomerRouter.CUSTOMER_ROOT, params = "email")
  public Customer getCustomerWithEmail(@RequestParam String email) {
    LOG.info("enter: email:", email);

    CustomerEntity entity = customerService.getByEmail(email);

    Customer customer = CustomerMapper.entityToModel(entity);

    LOG.info(EXIT_LOG_INFO, customer);
    return customer;
  }

  /**
   * login with google.
   *
   * @param gToken String
   * @return Customer
   */
  @GetMapping(value = CustomerRouter.CUSTOMER_ROOT, params = "gToken")
  public Customer getCustomerWithGoogleToken(@RequestParam String gToken) throws Exception {
    LOG.info("enter: idToken:", gToken);

    Customer customer = customerApplication.getOrCreateWithGoogleToken(gToken);

    LOG.info("exit: customer: {}", customer);
    return customer;
  }

  /**
   * get customer by id.
   *
   * @param id String customer id
   * @return Customer
   */
  @GetMapping(value = CustomerRouter.CUSTOMER_WITH_ID)
  public Customer getCustomerWithId(@PathVariable String id) {
    LOG.info("enter: id: {}", id);

    CustomerEntity customerEntity = customerService.getById(id);
    Customer customer = CustomerMapper.entityToModel(customerEntity);

    LOG.info(EXIT_LOG_INFO, customer);
    return customer;
  }

  /**
   * create new customer with email and password.
   *
   * @param emailModel email model.
   * @return
   */
  @PostMapping(value = CustomerRouter.CUSTOMER_ROOT)
  public Customer createCustomerWithEmail(
      @RequestBody SignupWithEmail emailModel) {
    LOG.info("enter: email: {}", emailModel.getEmail());
    CustomerEntity customerEntity = customerService.createWithEmail(emailModel.getEmail(),
        emailModel.getPassword());
    Customer customer = CustomerMapper.entityToModel(customerEntity);
    LOG.info("exit: customer:{}", customer);
    return customer;
  }

  /**
   * get payment id only.
   *
   * @param id customer id
   * @return payment id if exist, or null.
   */
  @ApiOperation("Update Customer with id")
  @GetMapping(value = CustomerRouter.PAYMENT_ROOT)
  public String getPaymentId(@PathVariable String id) {

    LOG.info("enter: customer id: {}", id);

    CustomerEntity customerEntity = customerService.getById(id);
    //TODO should we throw exception here?
    LOG.info(EXIT_LOG_INFO, customerEntity);
    return customerEntity.getPaymentId();
  }

  /**
   * update Customer.
   *
   * @param id            customer id String
   * @param updateRequest update request
   * @return updated Zone
   */
  @ApiOperation("Update Customer with id")
  @PutMapping(CustomerRouter.CUSTOMER_WITH_ID)
  public Customer updateZone(@PathVariable @ApiParam("customer id") String id,
                             @RequestBody @ApiParam("update request with version & update actions")
                                 UpdateRequest<CustomerUpdateAction> updateRequest) {
    LOG.info("enter: id: {}, UpdateRequest: {}", id, updateRequest);

    CustomerEntity entity = customerService.updateCustomer(id, updateRequest.getVersion(),
        updateRequest.getActions());

    Customer customer = CustomerMapper.entityToModel(entity);

    LOG.info(EXIT_LOG_INFO, customer);
    return customer;
  }
}
