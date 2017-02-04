package io.reactivesw.common.exception;

/**
 * Created by bruce on 16/11/15.
 */
public class AuthFailedException extends RuntimeException {

  /**
   * default constructor.
   */
  public AuthFailedException() {
    super();
  }

  /**
   * constructor with msg.
   *
   * @param msg message
   */
  public AuthFailedException(String msg) {
    super(msg);
  }
}
