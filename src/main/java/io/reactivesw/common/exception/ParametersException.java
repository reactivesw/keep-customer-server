package io.reactivesw.common.exception;

/**
 * Created by umasuo on 16/11/21.
 */
public class ParametersException extends RuntimeException {

  /**
   * default constructor.
   */
  public ParametersException() {
    super();
  }

  /**
   * constructor with message.
   *
   * @param message String
   */
  public ParametersException(String message) {
    super(message);
  }

}
