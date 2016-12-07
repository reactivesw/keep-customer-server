package io.reactivesw.common.exception;

/**
 * Created by bruce on 16/11/15.
 */
public class AlreadyExistException extends RuntimeException {

  /**
   * default constructor.
   */
  public AlreadyExistException() {
    super();
  }

  /**
   * constructor with message.
   *
   * @param message String
   */
  public AlreadyExistException(String message) {
    super(message);
  }
}
