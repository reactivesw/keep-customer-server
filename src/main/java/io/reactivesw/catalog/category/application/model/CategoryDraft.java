package io.reactivesw.catalog.category.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.CustomFieldsDraft;
import io.swagger.annotations.ApiModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Davis on 16/11/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel
public class CategoryDraft {

  /**
   * the name.
   */
  private LocalizedString name;

  /**
   * the description.
   */
  private LocalizedString description;

  /**
   * Reference to a CategoryEntity.
   * A category that is the parent of this category in the category tree.
   */
  private Reference parent;

  /**
   * human-readable identifier usually used as deep-link URL to the related category.
   * Allowed are alphabetic, numeric, underscore (_) and hyphen (-) characters.
   * Maximum size is 256.
   * Must be unique across a project!
   * The same category can have the same slug for different languages.
   */
  private LocalizedString slug;

  /**
   * An attribute as base for a custom category order in one level.
   */
  private String orderHint;

  /**
   * The External id.
   */
  private String externalId;

  /**
   * The Meta title.
   */
  private LocalizedString metaTitle;

  /**
   * The Meta description.
   */
  private LocalizedString metaDescription;

  /**
   * The Meta keywords.
   */
  private LocalizedString metaKeywords;

  /**
   * The custom fields.
   */
  private CustomFieldsDraft custom;
}
