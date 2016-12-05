package io.reactivesw.common.exceptions;

/**
 * Created by Davis on 16/11/28.
 */
public class NotExistException extends RuntimeException {
  public NotExistException() {
    super();
  }

  public NotExistException(String msg) {
    super(msg);
  }

}
