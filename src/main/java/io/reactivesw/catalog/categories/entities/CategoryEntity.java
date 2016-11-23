package io.reactivesw.catalog.categories.entities;

import io.reactivesw.common.entities.BaseTimeEntity;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;
import io.reactivesw.common.utils.LocalizedStringJsonConverter;
import io.reactivesw.common.utils.ListJsonConverter;

/**
 * Category Entity.
 * Created by rai on 16/11/13.
 */
@Entity
@Table(name = "sw_category")
public class CategoryEntity extends BaseTimeEntity {
  /**
   * The Id.
   */
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  @Column(name = "version")
  private Integer version;

  /**
   * The Name.
   */
  @Column(name = "name", nullable = false, columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString name;

  @Column(name = "slug", columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString slug;

  /**
   * The Description.
   */
  @Column(name = "description", columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString description;

  @Column(columnDefinition = "JSON")
  @Convert(converter = ListJsonConverter.class)
  private List<String> ancestors;

  @Column
  private String parent;

  @Column(name = "order_hint")
  private String orderHint;

  @Column(name = "external_id")
  private String externalId;

  @Column(name = "meta_title", columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaTitle;

  @Column(name = "meta_description", columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaDescription;

  @Column(name = "meta_key_words", columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString metaKeyWords;

  @Column(columnDefinition = "JSON")
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public LocalizedString getName() {
    return name;
  }

  public void setName(LocalizedString name) {
    this.name = name;
  }

  public LocalizedString getSlug() {
    return slug;
  }

  public void setSlug(LocalizedString slug) {
    this.slug = slug;
  }

  public LocalizedString getDescription() {
    return description;
  }

  public void setDescription(LocalizedString description) {
    this.description = description;
  }

  public List<String> getAncestors() {
    return ancestors;
  }

  public void setAncestors(List<String> ancestors) {
    this.ancestors = ancestors;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public String getOrderHint() {
    return orderHint;
  }

  public void setOrderHint(String orderHint) {
    this.orderHint = orderHint;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public LocalizedString getMetaTitle() {
    return metaTitle;
  }

  public void setMetaTitle(LocalizedString metaTitle) {
    this.metaTitle = metaTitle;
  }

  public LocalizedString getMetaDescription() {
    return metaDescription;
  }

  public void setMetaDescription(LocalizedString metaDescription) {
    this.metaDescription = metaDescription;
  }

  public LocalizedString getMetaKeyWords() {
    return metaKeyWords;
  }

  public void setMetaKeyWords(LocalizedString metaKeyWords) {
    this.metaKeyWords = metaKeyWords;
  }

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }
}
