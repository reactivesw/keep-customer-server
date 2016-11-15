package io.reactivesw.customer.server.catalog.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

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
  private int parentId;

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
  public CategoryEntity(String name, String description, int parentId) {

    this.name = name;
    this.description = description;
    this.parentId = parentId;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(int id) {
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
  public int getParentId() {
    return parentId;
  }

  /**
   * Sets parent id.
   *
   * @param parentId the parent id
   */
  public void setParentId(int parentId) {
    this.parentId = parentId;
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
