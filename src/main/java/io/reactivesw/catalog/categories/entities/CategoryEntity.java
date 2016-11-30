package io.reactivesw.catalog.categories.entities;

import io.reactivesw.common.entities.BaseAllEntity;
import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;
import io.reactivesw.common.utils.ListJsonConverter;
import io.reactivesw.common.utils.LocalizedStringJsonConverter;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * CategoryEntity Entity.
 * Created by rai on 16/11/13.
 */
@Entity
@Table(name = "catalog_category")
public class CategoryEntity extends BaseAllEntity {
  /**
   * json type.
   */
  private static final String JSONTYPE = "JSON";

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
  @Column(name = "description", columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString description;

  /**
   * ancestors.
   */
  @Column(columnDefinition = JSONTYPE)
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
  @Column(name = "meta_title", columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaTitle;

  /**
   * meta description.
   */
  @Column(name = "meta_description", columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaDescription;

  /**
   * meta key works.
   */
  @Column(name = "meta_key_words", columnDefinition = JSONTYPE)
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaKeyWords;

  /**
   * custom.
   */
  @Column(columnDefinition = JSONTYPE)
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
   * Gets meta key words.
   *
   * @return the meta key words
   */
  public LocalizedString getMetaKeyWords() {
    return metaKeyWords;
  }

  /**
   * Sets meta key words.
   *
   * @param metaKeyWords the meta key words
   */
  public void setMetaKeyWords(LocalizedString metaKeyWords) {
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
