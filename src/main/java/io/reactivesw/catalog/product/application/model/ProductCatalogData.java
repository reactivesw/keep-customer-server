package io.reactivesw.catalog.product.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCatalogData {
  /**
   * Whether the product is published.
   */
  private Boolean published;

  /**
   * The current data of the product.
   */
  private ProductData current;

  /**
   * The staged data of the product.
   */
  private ProductData staged;

  /**
   * Whether the staged data is different from the current data.
   */
  private Boolean hasStagedChanges;
}
