package io.reactivesw.common.exceptions;

/**
 * Created by Davis on 16/11/28.
 */
public class NotExistException extends RuntimeException {

  /**
   * default constructor.
   */
  public NotExistException() {
    super();
  }

  /**
   * constructor with message.
   *
   * @param msg String message
   */
  public NotExistException(String msg) {
    super(msg);
  }

}
