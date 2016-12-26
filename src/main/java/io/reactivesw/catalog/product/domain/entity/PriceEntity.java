package io.reactivesw.catalog.product.domain.entity;

import io.reactivesw.catalog.productdiscount.entity.ProductDiscountEntity;
import io.reactivesw.common.dialect.JSONBUserType;
import io.reactivesw.common.entity.BaseIdEntity;
import io.reactivesw.common.entity.MoneyEntity;
import io.reactivesw.common.model.CustomFields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "catalog_product_price")
@TypeDef(name = "Custom", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS, value = "io.reactivesw.common.model.CustomFields")}
)
public class PriceEntity extends BaseIdEntity {

  /**
   * value.
   */
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
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
   * channel id.
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
   * discounted.
   */
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private ProductDiscountEntity discounted;

  /**
   * custom.
   */
  @Type(type = "Custom")
  private CustomFields custom;
}
