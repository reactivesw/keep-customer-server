package io.reactivesw.customer.server.common.exceptions;

import java.util.List;

/**
 * Created by umasuo on 16/11/21.
 */
public class ErrorResponses {
  Integer statusCode;
  String message;
  List<ErrorResponse> errors;
}
