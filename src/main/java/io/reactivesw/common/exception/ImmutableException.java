package io.reactivesw.common.exception;

/**
 * Created by umasuo on 16/12/7.
 */
public class ImmutableException extends RuntimeException {

  /**
   * Instantiates a new Immutable exception.
   */
  public ImmutableException() {
    super();
  }

  /**
   * Instantiates a new Immutable exception.
   *
   * @param message the message
   */
  public ImmutableException(String message) {
    super(message);
  }
}
