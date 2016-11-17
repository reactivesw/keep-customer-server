package io.reactivesw.customer.server.catalog.models.draft;

import io.reactivesw.customer.server.common.types.LocalizedString;
import io.reactivesw.customer.server.common.types.Reference;
import io.reactivesw.customer.server.common.types.draft.CustomFieldsDraft;

/**
 * Created by Davis on 16/11/17.
 */
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
   * Reference to a Category.
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
  public CustomFieldsDraft getCustom() {
    return custom;
  }

  /**
   * Sets custom.
   *
   * @param custom the custom
   */
  public void setCustom(CustomFieldsDraft custom) {
    this.custom = custom;
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "CategoryDraft{" +
        "name=" + name +
        ", description=" + description +
        ", parent=" + parent +
        ", slug=" + slug +
        ", orderHint='" + orderHint + '\'' +
        ", externalId='" + externalId + '\'' +
        ", metaTitle=" + metaTitle +
        ", metaDescription=" + metaDescription +
        ", metaKeywords=" + metaKeywords +
        ", custom=" + custom +
        '}';
  }
}
