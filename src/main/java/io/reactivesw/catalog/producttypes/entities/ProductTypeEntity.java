package io.reactivesw.catalog.producttypes.entities;

import io.reactivesw.common.entities.BaseEntity;
import io.reactivesw.common.utils.ListJsonConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Davis on 16/11/22.
 */
@Entity
@Table(name = "sw_product_type")
public class ProductTypeEntity extends BaseEntity{
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

  @Column(name = "product_type_key")
  private String key;

  @Column
  private String name;

  @Column
  private String description;

  @Column(columnDefinition = "JSON")
  @Convert(converter = ListJsonConverter.class)
  //TODO ListJsonConverter可能不能正常工作,有问题需要写一个新的converter
  private List<AttributeDefinitionEntity> attributes;

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
   * Gets key.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets key.
   *
   * @param key the key
   */
  public void setKey(String key) {
    this.key = key;
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
   * Gets attributes.
   *
   * @return the attributes
   */
  public List<AttributeDefinitionEntity> getAttributes() {
    return attributes;
  }

  /**
   * Sets attributes.
   *
   * @param attributes the attributes
   */
  public void setAttributes(List<AttributeDefinitionEntity> attributes) {
    this.attributes = attributes;
  }
}
