package io.reactivesw.order.cartdiscount.application.model;

import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.Money;
import io.reactivesw.order.cartdiscount.infrastructure.enums.CartDiscountType;
import lombok.Data;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.OneToMany;

/**
 * Created by Davis on 16/11/17.
 */
@Data
public class CartDiscountValue {
  /**
   * The Type.reactive or absolute.
   */
  private CartDiscountType type;

  /**
   * The Permyriad.
   * Per ten thousand. The fraction the price is reduced. 1000 will result in a 10% price reduction.
   */
  private Integer permyriad;

  /**
   * The Money.
   */
  private List<Money> money;
}
