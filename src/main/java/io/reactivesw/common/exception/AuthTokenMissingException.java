package io.reactivesw.common.exception;

/**
 * Created by umasuo on 17/2/3.
 */
public class AuthTokenMissingException extends RuntimeException {

  /**
   * default constructor.
   */
  public AuthTokenMissingException() {
    super();
  }

  /**
   * constructor with message.
   *
   * @param msg
   */
  public AuthTokenMissingException(String msg) {
    super(msg);
  }
}
