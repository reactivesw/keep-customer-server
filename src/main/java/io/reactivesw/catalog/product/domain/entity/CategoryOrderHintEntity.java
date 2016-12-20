package io.reactivesw.catalog.product.domain.entity;

import io.reactivesw.common.entity.BaseIdEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/12/20.
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catalog_product_category")
public class CategoryOrderHintEntity extends BaseIdEntity{
  /**
   * category id.
   */
  @Column(name = "category_id")
  private String categoryId;

  /**
   * order hint.
   */
  @Column(name = "order_hint")
  private String orderHint;
}