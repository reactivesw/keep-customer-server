package io.reactivesw.order.cartdiscount.domain.entity;

import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/12/9.
 */
@Entity
@Table(name = "order_cart_discount_discount")
@Data
public class CartDiscountEntity extends BaseAllEntity {

  /**
   * The Version.
   */
  @Column
  private Integer version;

  /**
   * The Name.
   */
  @OneToMany
  private Set<LocalizedStringEntity> name;

  /**
   * The Description.
   */
  @OneToMany
  private Set<LocalizedStringEntity> description;

  /**
   * The Value.
   */
  @OneToOne
  private CartDiscountValue value;

  /**
   * The Cart predicate.
   * For now, we only support 'totalPrice'.
   * if null, then apply to all carts.
   */
  @Column
  private String cartPredicate;

  /**
   * The Target.
   */
  @OneToOne
  private CartDiscountTargetValue target;

  /**
   * The Sort order.
   */
  @Column
  private String sortOrder;

  /**
   * The Active.
   */
  @Column
  private Boolean active;

  /**
   * The Valid from.
   */
  @Column
  private ZonedDateTime validFrom;

  /**
   * The Valid until.
   */
  @Column
  private ZonedDateTime validUntil;

  /**
   * The Requires discount code.
   */
  @Column
  private Boolean requiresDiscountCode;

}
