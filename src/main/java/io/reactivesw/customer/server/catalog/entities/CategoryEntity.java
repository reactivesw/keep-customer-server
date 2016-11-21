package io.reactivesw.customer.server.catalog.entities;

import io.reactivesw.customer.server.common.utils.JpaConverterJson;
import io.reactivesw.customer.server.common.models.LocalizedString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category Entity.
 * Created by rai on 16/11/13.
 */
@Entity
@Table(name = "category")
public class CategoryEntity {
  /**
   * The Id.
   */
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "uuid", unique = true)
  private String id;

  /**
   * The Name.
   */
  @Column(name = "name", length = 32, nullable = false)
  private String name;

  /**
   * The Description.
   */
  @Column(name = "description", length = 1024)
  private String description;

  /**
   * The Sub categories.
   */
  @Column(name = "parent_id")
  private String parentId;

  @Column(name = "meta_title")
  @Convert(converter = JpaConverterJson.class)
  private LocalizedString metaTitle;


  /**
   * Instantiates a new Category entity.
   */
  public CategoryEntity() {
    // The explicit constructor is here, so that it is possible to provide Javadoc.
  }

  /**
   * Instantiates a new Category entity.
   *
   * @param name        the name
   * @param description the description
   */
  public CategoryEntity(String name, String description) {
    this.name = name;
    this.description = description;
  }

  /**
   * Instantiates a new Category entity.
   *
   * @param name        the name
   * @param description the description
   * @param parentId    the parent id
   */
  public CategoryEntity(String name, String description, String parentId) {

    this.name = name;
    this.description = description;
    this.parentId = parentId;
  }

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
   *
   * @return String
   */
  @Override
  public String toString() {
    return "CategoryEntity{ id=" + id + ", name='" + name + ", description='"
        + description + ", parentId=" + parentId + '}';
  }

  /**
   * equals method.
   *
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    boolean equalsResult = false;
    if (this == obj) {
      equalsResult = true;
    } else if (obj instanceof CategoryEntity) {
      final CategoryEntity other = (CategoryEntity) obj;
      equalsResult = Objects.equals(id, other.id) && Objects.equals(name, other.name)
          && Objects.equals(description, other.description)
          && Objects.equals(parentId, other.parentId);
    }
    return equalsResult;
  }

  /**
   * hashCode method.
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, parentId);
  }
}
