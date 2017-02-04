package io.reactivesw.common.exception;

/**
 * Created by umasuo on 17/2/4.
 */
public class CreateResourceFailed extends RuntimeException {

  /**
   * default constructor.
   */
  public CreateResourceFailed() {
    super();
  }

  /**
   * construtor with message.
   *
   * @param msg
   */
  public CreateResourceFailed(String msg) {
    super(msg);
  }
}
