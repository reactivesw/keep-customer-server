package io.reactivesw.catalog.category.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * category model.
 * Created by Davis on 16/11/14.
 */
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
  @JsonIgnore
  private LocalizedString slug;

  /**
   * The Description.
   */
  @ApiModelProperty(value = "CategoryEntity Description")
  @JsonIgnore
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
  @JsonIgnore
  private LocalizedString metaTitle;

  /**
   * The metaDescription.
   */
  @ApiModelProperty(value = "CategoryEntity metaDescription")
  @JsonIgnore
  private LocalizedString metaDescription;

  /**
   * the metaKeywords.
   */
  @ApiModelProperty(value = "CategoryEntity metaKeywords")
  @JsonIgnore
  private LocalizedString metaKeywords;

  /**
   * custom fields.
   */
  @ApiModelProperty(value = "CategoryEntity Custom Fields")
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

  public Category() {
    this.id = UUID.randomUUID().toString();
    LocalizedString localizedString = new LocalizedString();
    localizedString.addKeyValue("em", "testem");
    localizedString.addKeyValue("cn", "testcn");
    this.name = localizedString;
  }

  /**
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "CategoryEntity{" +
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
