package io.reactivesw.catalog.category.domain.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.reactivesw.common.dialect.JSONBUserType;
import io.reactivesw.common.entity.BaseAllEntity;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.model.CustomFields;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * CategoryEntity Entity.
 * Created by Davis on 16/11/13.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "catalog_category")
@TypeDef(name = "Custom", typeClass = JSONBUserType.class, parameters = {
    @Parameter(name = JSONBUserType.CLASS, value = "io.reactivesw.common.model.CustomFields")}
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
  @Column(unique = true)
  private String slug;

  /**
   * The Description.
   */
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<LocalizedStringEntity> description;

  /**
   * ancestors.
   */
  @ElementCollection
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
}