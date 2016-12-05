package io.reactivesw.catalog.categories.domains.entities;

import com.google.common.collect.Lists;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.reactivesw.common.dialects.JSONBUserType;
import io.reactivesw.common.entities.BaseAllEntity;
import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.models.CustomFields;

import org.apache.commons.lang3.StringUtils;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.Version;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * CategoryEntity Entity.
 * Created by rai on 16/11/13.
 */
@Entity
@Table(name = "catalog_category")
@TypeDef(name = "Custom", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS, value = "io.reactivesw.common.models.CustomFields")}
)
public class CategoryEntity extends BaseAllEntity {

  /**
   * ObjectMapper.
   */
  @Transient
  private final transient ObjectMapper objectMapper = new ObjectMapper();

  /**
   * version.
   */
  @Version
  @Column(name = "version")
  private Integer version;

  /**
   * The Name.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> name;

  /**
   * slug.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> slug;

  /**
   * The Description.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> description;

  /**
   * ancestors.
   */
  @Transient
  private List<String> ancestors;

  /**
   * ancestros string.
   */
  @Column
  private String ancestrosString = "";

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
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> metaTitle;

  /**
   * meta description.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> metaDescription;

  /**
   * meta key works.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> metaKeyWords;

  /**
   * custom.
   */
  @Type(type = "Custom")
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
    List result = new ArrayList();
    if (ancestors != null && !ancestors.isEmpty()) {
      result = Lists.newArrayList(ancestors);
    }
    if (StringUtils.isNotBlank(getAncestrosString())) {
      try {
        result = objectMapper.readValue(ancestrosString, List.class);
      } catch (IOException ex) {
        result = new ArrayList<>();
      }
    }
    return result;
  }

  /**
   * Sets ancestors.
   *
   * @param ancestors the ancestors
   */
  public void setAncestors(List<String> ancestors) {
    this.ancestors = ancestors;
    setAncestrosString();
  }

  /**
   * Gets ancestros string.
   *
   * @return the ancestros string
   */
  private String getAncestrosString() {
    return ancestrosString;
  }

  /**
   * Sets ancestros string.
   */
  private void setAncestrosString() {
    try {
      if (ancestors == null || ancestors.isEmpty()) {
        this.ancestrosString = "";
      } else {
        this.ancestrosString = objectMapper.writeValueAsString(ancestors);
      }
    } catch (JsonProcessingException jsonProcessingException) {
      this.ancestrosString = "";
    }
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