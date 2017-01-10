package io.reactivesw.authorization.application.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Created by umasuo on 17/1/10.
 */
@Data
@ApiModel
public class Token {

  /**
   * user id. like customer id, admin id.
   */
  private String userId;

  /**
   * user role. like customer, admin, service.
   */
  private String role;

  /**
   * scope list.
   */
  private List<String> scope;

  /**
   * token generate time.
   */
  private Long generateTime;

  /**
   * token available time.
   */
  private Long availableUntil;
}
