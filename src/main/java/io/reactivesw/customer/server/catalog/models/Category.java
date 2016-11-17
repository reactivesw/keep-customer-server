package io.reactivesw.customer.server.catalog.models;

import io.reactivesw.customer.server.common.utils.JpaConverterJson;
import io.reactivesw.customer.server.common.types.LocalizedString;

import javax.persistence.Convert;

/**
 * category model.
 * Created by Davis on 16/11/14.
 */
public class Category {
  /**
   * The Id.
   */
  private String id;
  /**
   * The Name.
   */
  private String name;
  /**
   * The Description.
   */
  private String description;
  /**
   * The Parent id.
   */
  private String parentId;

  /**
   * The Meta title.
   */
  @Convert(converter = JpaConverterJson.class)
  private LocalizedString metaTitle;

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
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets parent id.
   *
   * @return the parent id
   */
  public String getParentId() {
    return parentId;
  }

  /**
   * Sets parent id.
   *
   * @param parentId the parent id
   */
  public void setParentId(String parentId) {
    this.parentId = parentId;
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
   * toString method.
   * @return String
   */
  @Override
  public String toString() {
    return "Category{" + "id=" + id + ", name='" + name + ", description='" + description + '\''
        + ", parentId=" + parentId + '}';
  }
}
