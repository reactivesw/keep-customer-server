package io.reactivesw.customer.customer.domain.service;

import io.reactivesw.common.exception.AlreadyExistException;
import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.exception.PasswordErrorException;
import io.reactivesw.customer.customer.domain.entity.CustomerEntity;
import io.reactivesw.customer.customer.infrastructure.repository.CustomerRepository;
import io.reactivesw.customer.customer.infrastructure.util.PasswordUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by umasuo on 16/12/26.
 */
@Service
public class CustomerService {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(CustomerService.class);

  /**
   * customer repository.
   */
  @Autowired
  private transient CustomerRepository customerRepository;

  /**
   * get customer by id.
   *
   * @param id String
   * @return CustomerEntity
   */
  public CustomerEntity getById(String id) {
    LOG.debug("enter: id:{}", id);
    CustomerEntity entity = this.customerRepository.findOne(id);
    if (entity == null) {
      LOG.warn("customer not exist: id:{}", id);
      throw new NotExistException("customer not exist. id:" + id);
    }
    LOG.debug("exit: entity:{}", entity);
    return entity;
  }

  /**
   * get customer by customer name.
   *
   * @param name
   * @return
   */
  public CustomerEntity getByCustomerName(String name) {
    LOG.debug("enter: name:{}", name);
    CustomerEntity entity = this.customerRepository.findOneByCustomerName(name);
    if (entity == null) {
      LOG.debug("customer not exist: name:{}", name);
      throw new NotExistException("customer not exist. name:" + name);
    }
    LOG.debug("exit: entity:{}", entity);
    return entity;
  }

  /**
   * get customer by customer name.
   *
   * @param email
   * @return
   */
  public CustomerEntity getByEmail(String email) {
    LOG.debug("enter: name:{}", email);
    String lcEmail = email.toLowerCase(Locale.ENGLISH);
    CustomerEntity entity = this.customerRepository.findOneByEmail(lcEmail);
    if (entity == null) {
      LOG.debug("customer not exist: email:{}", lcEmail);
      throw new NotExistException("customer not exist. email:" + lcEmail);
    }
    LOG.debug("exit: entity:{}", entity);
    return entity;
  }

  /**
   * create customer with sample.
   * used for sign up.
   *
   * @param sample CustomerEntity
   * @return CustomerEntity
   */
  public CustomerEntity create(CustomerEntity sample) {
    LOG.debug("enter: sample: {}", sample);

    String customerName = sample.getCustomerName();
    if (StringUtils.isNotBlank(customerName)) {
      CustomerEntity existValue = this.customerRepository.findOneByCustomerName(customerName);
      if (existValue != null) {
        LOG.debug("error: customer already exist. customerName: {}", customerName);
        throw new AlreadyExistException("Customer already exist. customerName: " + customerName);
      }
    }


    String email = sample.getEmail().toLowerCase(Locale.ENGLISH);
    if (StringUtils.isNotBlank(email)) {
      CustomerEntity existValue = this.customerRepository.findOneByEmail(email);
      if (existValue != null) {
        LOG.debug("error: customer already exist. email: {}", email);
        throw new AlreadyExistException("Customer already exist. email: " + email);
      }
    }

    //email should be case-insensitive.
    sample.setEmail(email);
    //encrypt the password, only save encrypt password
    sample.setPassword(PasswordUtil.hashPassword(sample.getPassword()));
    LOG.debug("exit: customer create success.");
    return this.customerRepository.save(sample);
  }

  /**
   * sign in for customer.
   *
   * @param email    String
   * @param password String
   * @return CustomerEntity
   */
  public CustomerEntity signIn(String email, String password) {
    LOG.debug("enter: email: {}", email);
    CustomerEntity existCustomer = this.getByEmail(email);

    String hashedPassword = existCustomer.getPassword();
    this.checkPassword(password, hashedPassword);

    LOG.debug("exit: customer: {}", existCustomer);
    return existCustomer;
  }

  /**
   * change password for the customer.
   *
   * @param id              String
   * @param version         Integer
   * @param currentPassword String
   * @param newPassword     String
   * @return CustomerEntity
   */
  public CustomerEntity changePassword(String id, Integer version, String currentPassword, String
      newPassword) {
    LOG.debug("enter: change password. id: {}, version: {}", id, version);
    CustomerEntity existCustomer = this.getById(id);

    this.checkVersion(version, existCustomer.getVersion());

    String hashedPassword = existCustomer.getPassword();
    this.checkPassword(currentPassword, hashedPassword);

    existCustomer.setPassword(PasswordUtil.hashPassword(newPassword));

    LOG.debug("exit: customer: {}", existCustomer);
    return this.customerRepository.save(existCustomer);
  }

  /**
   * The token value is used to reset the password of the customer with the given email.
   * The token is valid only for 10 minutes.
   *
   * @param email String
   */
  public void createResetToken(String email) {
    LOG.debug("enter: email: {}", email);
    //TODO
  }

  /**
   * reset password.
   *
   * @param token       String
   * @param newPassword String
   * @param version     Integer
   */
  public void resetPassword(String token, String newPassword, Integer version) {
    LOG.debug("enter: token: {}, newPassword: {}, version: {}", token, newPassword, version);

  }

  /**
   * create verify email token.
   *
   * @param id      String
   * @param version Integer
   */
  public void createVerifyEmailToken(String id, Integer version) {
    LOG.debug("enter: id: {}, version: {}", id, version);
  }

  /**
   * verify email.
   *
   * @param token   String
   * @param version Integer
   */
  public void verifyEmail(String token, Integer version) {
    LOG.debug("enter: token: {}, version: {}", token, version);
  }

  /**
   * delete an customer.
   *
   * @param id      String
   * @param version Integer
   */
  public void deleteCustomer(String id, Integer version) {
    LOG.debug("enter: id: {}, version: {}", id, version);
    CustomerEntity existCustomer = this.getById(id);

    this.checkVersion(version, existCustomer.getVersion());

    LOG.debug("exit.");
    this.customerRepository.delete(id);
  }


  /**
   * check the version.
   *
   * @param inputVersion Integer
   * @param existVersion Integer
   */
  private void checkVersion(Integer inputVersion, Integer existVersion) {
    if (!inputVersion.equals(existVersion)) {
      LOG.debug("Customer version is not correct.");
      throw new ConflictException("Customer version is not correct.");
    }
  }

  /**
   * check if two password is the same, if not, then throw password error exception.
   *
   * @param originPassword String
   * @param hashedPassword String
   */
  private void checkPassword(String originPassword, String hashedPassword) {
    Boolean result = PasswordUtil.checkPassword(originPassword, hashedPassword);
    if (!result) {
      LOG.debug("Password not correct ");
      throw new PasswordErrorException("Password not correct.");
    }
  }
}
