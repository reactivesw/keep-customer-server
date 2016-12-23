package io.reactivesw.catalog.category.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * category model.
 * Created by Davis on 16/11/14.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {
  /**
   *  The unique ID of the category.
   */
  @ApiModelProperty(value = "The unique ID of the category")
  private String id;

  /**
   *  The current version of the category.
   */
  @ApiModelProperty(value = "The current version of the category")
  private Integer version;

  /**
   * create time.
   */
  @ApiModelProperty(value = "Create Time")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * last modified time.
   */
  @ApiModelProperty(value = "Last Modified Time")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * The Name.
   */
  @ApiModelProperty(value = "CategoryEntity Name")
  @JsonUnwrapped
  private LocalizedString name;

  /**
   * human-readable identifiers usually used as deep-link URL to the related category.
   * Each slug is unique across a project,
   * but a category can have the same slug for different languages.
   */
  @ApiModelProperty(value = "CategoryEntity Slug")
  private String slug;

  /**
   * The Description.
   */
  @ApiModelProperty(value = "CategoryEntity Description")
  private LocalizedString description;

  /**
   *  Contains the parent path towards the root category.
   */
  @ApiModelProperty(value = "Contains the parent path towards the root category")
  private List<Reference> ancestors;

  /**
   *  A category that is the parent of this category in the category tree.
   */
  @ApiModelProperty(value = "A category that is the parent of this category in the category tree")
  private Reference parent;

  /**
   *  An attribute as base for a custom category order in one level.
   */
  @ApiModelProperty(value = "An attribute as base for a custom category order in one level")
  private String orderHint;

  /**
   * externalId.
   */
  @ApiModelProperty(value = "CategoryEntity externalId")
  private String externalId;

  /**
   * The Meta title.
   */
  @ApiModelProperty(value = "CategoryEntity metaTitle")
  private LocalizedString metaTitle;

  /**
   * The metaDescription.
   */
  @ApiModelProperty(value = "CategoryEntity metaDescription")
  private LocalizedString metaDescription;

  /**
   * the metaKeywords.
   */
  @ApiModelProperty(value = "CategoryEntity metaKeywords")
  private LocalizedString metaKeywords;

  /**
   * custom fields.
   */
  @ApiModelProperty(value = "CategoryEntity Custom Fields")
  private CustomFields custom;
}
