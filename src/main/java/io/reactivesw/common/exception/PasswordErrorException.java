package io.reactivesw.common.exception;

/**
 * Created by umasuo on 16/12/27.
 */
public class PasswordErrorException extends RuntimeException {

  /**
   * default constructor.
   */
  public PasswordErrorException() {
    super();
  }

  /**
   * constructor with error message.
   *
   * @param msg message
   */
  public PasswordErrorException(String msg) {
    super(msg);
  }

}
