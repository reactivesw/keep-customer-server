package io.reactivesw.common.model;

import lombok.Data;

/**
 * Created by Davis on 16/11/16.
 */
@Data
public class Money {
  /**
   * The Currency code.
   */
  private String currencyCode;

  /**
   * The Cent amount.
   */
  private Integer centAmount;
}
