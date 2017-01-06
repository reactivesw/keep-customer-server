package io.reactivesw.order.order.domain.entity.value;

import io.reactivesw.catalog.productdiscount.model.DiscountedPrice;
import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.util.converter.CustomFieldsJsonConverter;
import io.reactivesw.common.util.converter.DiscountedPriceJsonConverter;
import lombok.Data;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by umasuo on 16/11/28.
 */
@Entity
@Table(name = "order_cart_price")
@Data
public class PriceValue extends BaseIdEntity {

  /**
   * value.
   */
  @OneToOne
  private MoneyEntity value;

  /**
   * country.
   */
  @Column(name = "country")
  private String country;

  /**
   * customer group.
   */
  @Column(name = "customer_group_id")
  private String customerGroup;

  /**
   * channel.
   */
  @Column(name = "chanel_id")
  private String channel;

  /**
   * valid from.
   */
  @Column(name = "valid_from")
  private ZonedDateTime validFrom;

  /**
   * valid until.
   */
  @Column(name = "valid_until")
  private ZonedDateTime validUntil;

  /**
   * discounted price.
   */
  @Column(name = "discounted", columnDefinition = "JSON")
  @Convert(converter = DiscountedPriceJsonConverter.class)
  private DiscountedPrice discounted;

  /**
   * custom fields.
   */
  @Column(name = "custom", columnDefinition = "JSON")
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;
}
