package io.reactivesw.customer.customer.infrastructure.enums;

/**
 * Created by umasuo on 16/12/28.
 */
public enum TokenType {
  CUSTOMER_LOGIN("LOGIN"),
  CUSTOMER_VERIFY_EMAIL("VERIFY_EMAIL"),
  CUSTOMER_RESET_EMAIL("RESET_EMAIL");

  /**
   * value.
   */
  private String value;

  /**
   * private constructor.
   *
   * @param value String
   */
  TokenType(String value) {
    this.value = value;
  }

  /**
   * get string value.
   *
   * @return String
   */
  public String getValue() {
    return value;
  }
}
