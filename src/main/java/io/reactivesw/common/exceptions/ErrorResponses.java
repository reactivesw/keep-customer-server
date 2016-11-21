package io.reactivesw.common.exceptions;

import java.util.List;

/**
 * Created by umasuo on 16/11/21.
 */
public class ErrorResponses {
  /**
   * code.
   */
  Integer statusCode;

  /**
   * message.
   */
  String message;

  /**
   * errors.
   */
  List<ErrorResponse> errors;

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<ErrorResponse> getErrors() {
    return errors;
  }

  public void setErrors(List<ErrorResponse> errors) {
    this.errors = errors;
  }
}
