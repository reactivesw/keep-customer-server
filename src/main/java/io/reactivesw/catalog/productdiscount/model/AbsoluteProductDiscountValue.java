package io.reactivesw.catalog.productdiscount.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.reactivesw.common.model.Base;
import io.reactivesw.common.model.Money;

import java.util.Collections;
import java.util.List;

/**
 *
 */
public final class AbsoluteProductDiscountValue extends Base implements ProductDiscountValue {
  private final List<Money> money;

  @JsonCreator
  private AbsoluteProductDiscountValue(final List<Money> money) {
    this.money = money;
  }

  /**
   * The array contains money value in different currencies. An absolute product discount will
   * only match a price if this array contains a value with the same currency. If it contains
   * 10€ and 15$, the matching € price will be decreased by 10€ and the matching $ price will
   * be decreased by 15$.
   *
   * @return list of discount value
   */
  public List<Money> getMoney() {
    return money;
  }

  public static AbsoluteProductDiscountValue of(final List<Money> money) {
    return new AbsoluteProductDiscountValue(money);
  }

  public static AbsoluteProductDiscountValue of(final Money money) {
    return new AbsoluteProductDiscountValue(Collections.singletonList(money));
  }
}

