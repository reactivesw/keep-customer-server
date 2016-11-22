package io.reactivesw.catalog.categories.entities;

import com.fasterxml.jackson.databind.JsonNode;

import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.utils.JpaConverterJson;
import io.reactivesw.common.models.LocalizedString;
import springfox.documentation.spring.web.json.Json;

import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category Entity.
 * Created by rai on 16/11/13.
 */
@Entity
@Table(name = "sw_category")
public class CategoryEntity {
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

  @Column(name = "created_at")
  private ZonedDateTime createdAt;

  @Column(name = "last_modified_at")
  private ZonedDateTime lastModifiedAt;

  /**
   * The Name.
   */
  @Column(name = "name", nullable = false)
  private LocalizedString name;

  @Column(name = "slug")
  private LocalizedString slug;

  /**
   * The Description.
   */
  @Column(name = "description")
  private LocalizedString description;

  @Column
  @ElementCollection
  private List<String> ancestors;

  @Column
  private String parent;

  @Column(name = "order_hint")
  private String orderHint;

  @Column(name = "external_id")
  private String externalId;

  @Column(name = "meta_title")
  private LocalizedString metaTitle;

  @Column(name = "meta_description")
  private LocalizedString metaDescription;

  @Column(name = "meta_key_words")
  private LocalizedString metaKeyWords;

  @Column
  private JsonNode custom;

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

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
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

  public JsonNode getCustom() {
    return custom;
  }

  public void setCustom(JsonNode custom) {
    this.custom = custom;
  }
}
