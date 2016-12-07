package io.reactivesw.catalog.productdiscount.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.reactivesw.common.model.Base;

public final class RelativeProductDiscountValue extends Base implements ProductDiscountValue {
  private final Integer permyriad;

  @JsonCreator
  private RelativeProductDiscountValue(final Integer permyriad) {
    this.permyriad = permyriad;
  }

  /**
   * Per ten thousand. The fraction the price is reduced. 1000 will result in a 10% price
   * reduction.
   *
   * @return permyriad
   */
  public Integer getPermyriad() {
    return permyriad;
  }

  /**
   * Alias for {@link RelativeProductDiscountValue#getPermyriad()}
   *
   * @return permyriad
   */
  public Integer getBasisPoint() {
    return getPermyriad();
  }

  public static RelativeProductDiscountValue of(final Integer permyriad) {
    return new RelativeProductDiscountValue(permyriad);
  }
}
