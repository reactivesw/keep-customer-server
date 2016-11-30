package io.reactivesw.catalog.categories.domains.entities;

import io.reactivesw.common.entities.BaseAllEntity;
import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;
import io.reactivesw.common.utils.ListJsonConverter;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * CategoryEntity Entity.
 * Created by rai on 16/11/13.
 */
@Entity
@Table(name = "catalog_category")
public class CategoryEntity extends BaseAllEntity {
  /**
   * version.
   */
  @Version
  @Column(name = "version")
  private Integer version;

  /**
   * The Name.
   */
  @OneToMany
  private Set<LocalizedStringEntity> name;

  /**
   * slug.
   */
  @OneToMany
  private Set<LocalizedStringEntity> slug;

  /**
   * The Description.
   */
  @OneToMany
  private Set<LocalizedStringEntity> description;

  /**
   * ancestors.
   */
  @Column(columnDefinition = "jsonb")
  @Convert(converter = ListJsonConverter.class)
  private List<String> ancestors;

  /**
   * parent id.
   */
  @Column
  private String parent;

  /**
   * order hint.
   */
  @Column(name = "order_hint")
  private String orderHint;

  /**
   * external id.
   */
  @Column(name = "external_id")
  private String externalId;

  /**
   * meta title.
   */
  @OneToMany
  private Set<LocalizedStringEntity> metaTitle;

  /**
   * meta description.
   */
  @OneToMany
  private Set<LocalizedStringEntity> metaDescription;

  /**
   * meta key works.
   */
  @OneToMany
  private Set<LocalizedStringEntity> metaKeyWords;

  /**
   * custom.
   */
  @Column(columnDefinition = "jsonb")
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

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
   * Gets name.
   *
   * @return the name
   */
  public Set<LocalizedStringEntity> getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(Set<LocalizedStringEntity> name) {
    this.name = name;
  }

  /**
   * Gets slug.
   *
   * @return the slug
   */
  public Set<LocalizedStringEntity> getSlug() {
    return slug;
  }

  /**
   * Sets slug.
   *
   * @param slug the slug
   */
  public void setSlug(Set<LocalizedStringEntity> slug) {
    this.slug = slug;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public Set<LocalizedStringEntity> getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(Set<LocalizedStringEntity> description) {
    this.description = description;
  }

  /**
   * Gets ancestors.
   *
   * @return the ancestors
   */
  public List<String> getAncestors() {
    return ancestors;
  }

  /**
   * Sets ancestors.
   *
   * @param ancestors the ancestors
   */
  public void setAncestors(List<String> ancestors) {
    this.ancestors = ancestors;
  }

  /**
   * Gets parent.
   *
   * @return the parent
   */
  public String getParent() {
    return parent;
  }

  /**
   * Sets parent.
   *
   * @param parent the parent
   */
  public void setParent(String parent) {
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
  public Set<LocalizedStringEntity> getMetaTitle() {
    return metaTitle;
  }

  /**
   * Sets meta title.
   *
   * @param metaTitle the meta title
   */
  public void setMetaTitle(Set<LocalizedStringEntity> metaTitle) {
    this.metaTitle = metaTitle;
  }

  /**
   * Gets meta description.
   *
   * @return the meta description
   */
  public Set<LocalizedStringEntity> getMetaDescription() {
    return metaDescription;
  }

  /**
   * Sets meta description.
   *
   * @param metaDescription the meta description
   */
  public void setMetaDescription(Set<LocalizedStringEntity> metaDescription) {
    this.metaDescription = metaDescription;
  }

  /**
   * Gets meta key words.
   *
   * @return the meta key words
   */
  public Set<LocalizedStringEntity> getMetaKeyWords() {
    return metaKeyWords;
  }

  /**
   * Sets meta key words.
   *
   * @param metaKeyWords the meta key words
   */
  public void setMetaKeyWords(Set<LocalizedStringEntity> metaKeyWords) {
    this.metaKeyWords = metaKeyWords;
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
   *
   * @return String
   */
  @Override
  public String toString() {
    return "CategoryEntity{"
        + "version=" + version
        + ", name=" + name
        + ", slug=" + slug
        + ", description=" + description
        + ", ancestors=" + ancestors
        + ", parent='" + parent + '\''
        + ", orderHint='" + orderHint + '\''
        + ", externalId='" + externalId + '\''
        + ", metaTitle=" + metaTitle
        + ", metaDescription=" + metaDescription
        + ", metaKeyWords=" + metaKeyWords
        + ", custom=" + custom
        + '}';
  }
}
