package io.reactivesw.project.application.model;

import lombok.Data;

/**
 * Created by umasuo on 17/1/5.
 */
@Data
public class Currency {

  /**
   * id.
   */
  private String id;

  /**
   * currency code.
   */
  private String currencyCode;

  /**
   * name.
   */
  private String name;
}
