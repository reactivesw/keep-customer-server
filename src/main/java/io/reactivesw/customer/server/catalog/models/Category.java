package io.reactivesw.customer.server.catalog.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.reactivesw.customer.server.common.types.CustomFields;
import io.reactivesw.customer.server.common.types.Reference;
import io.reactivesw.customer.server.common.utils.JpaConverterJson;
import io.reactivesw.customer.server.common.types.LocalizedString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Convert;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * category model.
 * Created by Davis on 16/11/14.
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
  /**
   *  The unique ID of the category.
   */
  @ApiModelProperty(required = true)
  private String id;

  /**
   *  The current version of the category.
   */
  private Integer version;

  /**
   * create time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * last modified time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * The Name.
   */
  @JsonIgnore
  private LocalizedString name;

  /**
   * human-readable identifiers usually used as deep-link URL to the related category.
   * Each slug is unique across a project,
   * but a category can have the same slug for different languages. TODO
   */
  @JsonIgnore
  private LocalizedString slug;

  /**
   * The Description. TODO
   */
  @JsonIgnore
  private LocalizedString description;

  /**
   *  Contains the parent path towards the root category.
   */
  private List<Reference> ancestors;

  /**
   *  A category that is the parent of this category in the category tree.
   */
  private Reference parent;

  /**
   *  An attribute as base for a custom category order in one level.
   */
  private String orderHint;

  /**
   * externalId.
   */
  private String externalId;

  /**
   * The Meta title. TODO
   */
  @JsonIgnore
  private LocalizedString metaTitle;

  /**
   * The metaDescription. TODO
   */
  @JsonIgnore
  private LocalizedString metaDescription;

  /**
   * the metaKeywords. TODO
   */
  @JsonIgnore
  private LocalizedString metaKeywords;

  /**
   * custom fields.
   */
  private CustomFields custom;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Gets created at.
   *
   * @return the created at
   */
  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets last modified at.
   *
   * @return the last modified at
   */
  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Sets last modified at.
   *
   * @param lastModifiedAt the last modified at
   */
  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public LocalizedString getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(LocalizedString name) {
    this.name = name;
  }

  /**
   * Gets slug.
   *
   * @return the slug
   */
  public LocalizedString getSlug() {
    return slug;
  }

  /**
   * Sets slug.
   *
   * @param slug the slug
   */
  public void setSlug(LocalizedString slug) {
    this.slug = slug;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public LocalizedString getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(LocalizedString description) {
    this.description = description;
  }

  /**
   * Gets ancestors.
   *
   * @return the ancestors
   */
  public List<Reference> getAncestors() {
    return ancestors;
  }

  /**
   * Sets ancestors.
   *
   * @param ancestors the ancestors
   */
  public void setAncestors(List<Reference> ancestors) {
    this.ancestors = ancestors;
  }

  /**
   * Gets parent.
   *
   * @return the parent
   */
  public Reference getParent() {
    return parent;
  }

  /**
   * Sets parent.
   *
   * @param parent the parent
   */
  public void setParent(Reference parent) {
    this.parent = parent;
  }

  /**
   * Gets order hint.
   *
   * @return the order hint
   */
  public String getOrderHint() {
    return orderHint;
  }

  /**
   * Sets order hint.
   *
   * @param orderHint the order hint
   */
  public void setOrderHint(String orderHint) {
    this.orderHint = orderHint;
  }

  /**
   * Gets external id.
   *
   * @return the external id
   */
  public String getExternalId() {
    return externalId;
  }

  /**
   * Sets external id.
   *
   * @param externalId the external id
   */
  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  /**
   * Gets meta title.
   *
   * @return the meta title
   */
  public LocalizedString getMetaTitle() {
    return metaTitle;
  }

  /**
   * Sets meta title.
   *
   * @param metaTitle the meta title
   */
  public void setMetaTitle(LocalizedString metaTitle) {
    this.metaTitle = metaTitle;
  }

  /**
   * Gets meta description.
   *
   * @return the meta description
   */
  public LocalizedString getMetaDescription() {
    return metaDescription;
  }

  /**
   * Sets meta description.
   *
   * @param metaDescription the meta description
   */
  public void setMetaDescription(LocalizedString metaDescription) {
    this.metaDescription = metaDescription;
  }

  /**
   * Gets meta keywords.
   *
   * @return the meta keywords
   */
  public LocalizedString getMetaKeywords() {
    return metaKeywords;
  }

  /**
   * Sets meta keywords.
   *
   * @param metaKeywords the meta keywords
   */
  public void setMetaKeywords(LocalizedString metaKeywords) {
    this.metaKeywords = metaKeywords;
  }

  /**
   * Gets custom.
   *
   * @return the custom
   */
  public CustomFields getCustom() {
    return custom;
  }

  /**
   * Sets custom.
   *
   * @param custom the custom
   */
  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "Category{" +
        "id='" + id + '\'' +
        ", version=" + version +
        ", createdAt=" + createdAt +
        ", lastModifiedAt=" + lastModifiedAt +
        ", name=" + name +
        ", slug=" + slug +
        ", description=" + description +
        ", ancestors=" + ancestors +
        ", parent=" + parent +
        ", orderHint='" + orderHint + '\'' +
        ", externalId='" + externalId + '\'' +
        ", metaTitle=" + metaTitle +
        ", metaDescription=" + metaDescription +
        ", metaKeywords=" + metaKeywords +
        ", custom=" + custom +
        '}';
  }
}
