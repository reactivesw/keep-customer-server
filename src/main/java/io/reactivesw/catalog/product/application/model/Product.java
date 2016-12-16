package io.reactivesw.catalog.product.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.reactivesw.catalog.review.model.ReviewRatingStatistics;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
  /**
   * The unique ID of the product.
   */
  @ApiModelProperty(required = true)
  private String id;

  /**
   * User-specific unique identifier for the product.
   * Product keys are different from product variant keys.
   */
  @ApiModelProperty(required = false)
  private String key;

  /**
   * The current version of the product.
   */
  @ApiModelProperty(required = true)
  private Integer version;

  /**
   * The Create at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * last modified time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * Reference to a ProductType.
   */
  private Reference productType;

  /**
   * The product data in the master catalog.
   */
  private ProductCatalogData masterData;

  /**
   * Reference to a TaxCategory.
   */
  private Reference taxCategory;

  /**
   * Reference to a State.
   * Optional.
   */
  private Reference state;

  /**
   * Statistics about the review ratings taken into account for this product.
   * Statistics about the review ratings taken into account for this product.
   * Optional.
   */
  private ReviewRatingStatistics reviewRatingStatistics;
}
