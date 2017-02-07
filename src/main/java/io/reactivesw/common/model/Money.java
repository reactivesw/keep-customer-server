package io.reactivesw.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Davis on 16/11/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
