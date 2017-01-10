package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Statics;
import io.reactivesw.common.util.converter.CustomFieldsJsonConverter;
import io.reactivesw.common.util.converter.ListJsonConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
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
@Table(name = "order_custom_line_item")
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomLineItemValue extends BaseIdEntity {

  /**
   * name in localized string.
   */
  @OneToMany
  private Set<LocalizedStringEntity> name;

  /**
   * money.
   * The cost to add to the cart. The amount can be negative.
   */
  @OneToOne
  private MoneyEntity money;

  /**
   * taxed item price value.
   * Set once the taxRate is set.
   */
  @OneToOne
  private TaxedItemPriceValue taxedPrice;

  /**
   * total price.
   */
  @OneToOne
  private MoneyEntity totalPrice;

  /**
   * slug.
   */
  @Column
  private String slug;

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
   * tax category.
   */
  @Column(name = "tax_category")
  private String taxCategory;

  /**
   * tax rate id.
   */
  @OneToOne
  private TaxRateValue taxRate;

  /**
   * DiscountedLineItemPriceForQuantity ids.
   */
  @Column(name = "discount_codes", columnDefinition = Statics.JSON)
  @Convert(converter = ListJsonConverter.class)
  private List<String> discountedPricePerQuantity;

  /**
   * custom fields.
   */
  @Column(name = "custom", nullable = false, columnDefinition = Statics.JSON)
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

}
