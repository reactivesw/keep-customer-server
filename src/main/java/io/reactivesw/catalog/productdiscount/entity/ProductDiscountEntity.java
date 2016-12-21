package io.reactivesw.catalog.productdiscount.entity;

import io.reactivesw.catalog.productdiscount.model.ProductDiscountValue;
import io.reactivesw.common.dialect.JSONBUserType;
import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/23.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "catalog_product_product_discount")
@TypeDef(name = "ProductDiscountValue", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS,
        value = "io.reactivesw.catalog.productdiscount.model.ProductDiscountValue")}
)
public class ProductDiscountEntity extends BaseAllEntity {
  /**
   * name.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> name;

  /**
   * description.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> description;

  /**
   * value.
   */
  @Type(type = "ProductDiscountValue")
  private ProductDiscountValue value;

  /**
   * predicate.
   */
  @Column
  private String predicate;

  /**
   * sort order.
   */
  @Column(name = "sort_order")
  private String sortOrder;

  /**
   * active.
   */
  @Column
  private Boolean active;
}
