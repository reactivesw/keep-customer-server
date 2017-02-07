package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Statics;
import io.reactivesw.common.util.converter.CustomFieldsJsonConverter;
import io.reactivesw.order.cartdiscount.infrastructure.enums.LineItemPriceMode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "order_line_item")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = {"productId", "supplyChannel", "distributionChannel"})
public class LineItemValue extends BaseIdEntity {

  /**
   * product id.
   */
  @Column(name = "product_id")
  private String productId;

  /**
   * name in localized string.
   */
  @OneToMany
  private Set<LocalizedStringEntity> name;

  /**
   * product slug in localized string.
   */
  @Column
  private String productSlug;

  /**
   * product variant.
   * a snap shop for variant.
   */
  @OneToOne
  private ProductVariantValue variant;

  /**
   * price.
   */
  @OneToOne
  private PriceValue price;

  /**
   * TaxedItemPriceValue.
   */
  @OneToOne
  private TaxedItemPriceValue taxedPrice;

  /**
   * The total price of this line item. If the line item is discounted, then the totalPrice is
   * the DiscountedLineItemPriceForQuantity multiplied by quantity. Otherwise the total price is
   * the product price multiplied by the quantity. totalPrice may or may not include the taxes:
   * it depends on the taxRate.includedInPrice property.
   */
  @OneToOne
  private MoneyEntity totalPrice;

  /**
   * quantity.
   */
  @Column
  private Integer quantity;

  /**
   * list of item state.
   */
  @OneToMany
  private Set<ItemStateValue> state;

  /**
   * tax rate.
   */
  @OneToOne
  private TaxRateValue taxRate;

  /**
   * supplyChannel.
   */
  @Column(name = "supply_channel")
  private String supplyChannel;

  /**
   * distributionChannel.
   */
  @Column(name = "distribution_channel")
  private String distributionChannel;

  /**
   * DiscountedLineItemPriceForQuantity ids.
   * TODO we will use this later.
   */
  @Column(name = "discounted_price_for_quantity")
  private String discountedPriceForQuantity;

  /**
   * price mode.
   */
  @Column(name = "price_mode")
  private LineItemPriceMode priceMode;

  /**
   * custom fields.
   */
  @Column(name = "custom", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

}
