package io.reactivesw.customer.customer.infrastructure.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by umasuo on 16/12/26.
 */
public class EmailAuthenticator extends Authenticator {

  private String userName = "";
  private String password = "";

  /**
   * default constructor.
   */
  public EmailAuthenticator() {
  }

  /**
   * constructor.
   */
  public EmailAuthenticator(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(userName, password);
  }
}
