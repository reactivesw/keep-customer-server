package io.reactivesw.catalog.product.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by umasuo on 16/11/18.
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CategoryOrderHint {

  /**
   * use category id as key.
   */
  String key;

  /**
   * number, value between [0...1]
   */
  String order;
}
