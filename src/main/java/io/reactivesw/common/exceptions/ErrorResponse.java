package io.reactivesw.common.exceptions;

/**
 * Created by umasuo on 16/11/21.
 */
public class ErrorResponse {

  /**
   * code.
   */
  Integer code;

  /**
   * message.
   */
  String message;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
