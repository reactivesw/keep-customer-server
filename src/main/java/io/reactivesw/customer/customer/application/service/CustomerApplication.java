package io.reactivesw.customer.customer.application.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.customer.customer.application.model.Customer;
import io.reactivesw.customer.customer.application.model.mapper.CustomerMapper;
import io.reactivesw.customer.customer.domain.entity.CustomerEntity;
import io.reactivesw.customer.customer.domain.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

/**
 * Created by umasuo on 17/1/10.
 */
@Service
public class CustomerApplication {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(CustomerApplication.class);

  /**
   * HTTP TRANSPORT.
   */
  private transient final HttpTransport TRANSPORT = new NetHttpTransport();

  /**
   * Default JSON factory to use to deserialize JSON.
   */
  private transient final JacksonFactory JSON_FACTORY = new JacksonFactory();

  /**
   * google token verifier.
   */
  private transient GoogleIdTokenVerifier verifier;

  /**
   * customer service.
   */
  @Autowired
  private transient CustomerService customerService;

  /**
   * default config.
   */
  public CustomerApplication() {
    this.verifier = new GoogleIdTokenVerifier.Builder(TRANSPORT, JSON_FACTORY)
        //TODO use config
        .setAudience(Collections.singletonList("131564184321-8o7d2rtmansr22v7hlubvjkqmqgkd08h" +
            ".apps.googleusercontent.com"))
        .build();
  }

  /**
   * login with google token.
   *
   * @param gToken String
   * @return customer.
   * @throws GeneralSecurityException
   * @throws IOException
   */
  public Customer loginWithGoogleToken(String gToken) throws GeneralSecurityException, IOException {
    LOG.debug("enter: gToken: {}", gToken);
    GoogleIdToken idToken = this.verifyToken(gToken);

    GoogleIdToken.Payload payload = idToken.getPayload();
    String id = payload.getSubject();
    CustomerEntity customerEntity = customerService.getByExternalId(id);

    if (customerEntity == null) {
      customerEntity = createWithGooglePayload(payload);
    }

    LOG.debug("exit: customerEntity: {}", customerEntity);
    return CustomerMapper.entityToModel(customerEntity);
  }

  /**
   * create new customer with google payload.
   *
   * @param payload GoogleIdToken.Payload
   * @return CustomerEntity
   */
  private CustomerEntity createWithGooglePayload(GoogleIdToken.Payload payload) {
    CustomerEntity customerEntity = new CustomerEntity();
    String id = payload.getSubject();
    String locale = (String) payload.get("locale");
    String familyName = (String) payload.get("family_name");
    String givenName = (String) payload.get("given_name");

    //TODO should we save the email?
    customerEntity.setExternalId(id);
    customerEntity.setFirstName(givenName);
    customerEntity.setLastName(familyName);
    customerEntity.setLocale(locale);

    LOG.debug("create new customer with external info. customerEntity: {}", customerEntity);
    return customerService.createWithExternal(customerEntity);
  }

  /**
   * verify google token.
   *
   * @param token String
   * @return GoogleIdToken
   * @throws GeneralSecurityException
   * @throws IOException
   */
  private GoogleIdToken verifyToken(String token) throws GeneralSecurityException, IOException {
    LOG.debug("enter: gToken: {}", token);

    GoogleIdToken idToken = verifier.verify(token);

    if (idToken == null) {
      LOG.debug(" google token verify failed: gToken: {}", token);
      throw new ParametersException("Google's id token is not correct.");
    }

    LOG.debug("exist: googleIdToken: {}", idToken);
    return idToken;
  }

}
