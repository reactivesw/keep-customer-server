package io.reactivesw.customer.server.catalog.models;

/**
 * category model.
 * Created by Davis on 16/11/14.
 */
public class Category {
  /**
   * The Id.
   */
  private Integer id;
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
  private Integer parentId;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Integer id) {
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
  public Integer getParentId() {
    return parentId;
  }

  /**
   * Sets parent id.
   *
   * @param parentId the parent id
   */
  public void setParentId(Integer parentId) {
    this.parentId = parentId;
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
