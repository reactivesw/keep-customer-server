package io.reactivesw.base.entities;

import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.utils.CustomFieldsJsonConverter;
import io.reactivesw.common.utils.ListJsonConverter;
import io.reactivesw.common.utils.LocalizedStringJsonConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * Created by Davis on 16/11/23.
 */
@Entity
@Table(name = "sw_asset")
public class AssetEntity {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  @OneToMany
  private Set<AssetSourceEntity> sources;

  @Column(name = "name", columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString name;

  @Column(name = "description", columnDefinition = "JSON")
  @Convert(converter = LocalizedStringJsonConverter.class)
  private LocalizedString description;

  @Column(name = "tags", columnDefinition = "JSON")
  @Convert(converter = ListJsonConverter.class)
  private List<String> tags;

  @Column(name = "custom", columnDefinition = "JSON")
  @Convert(converter = CustomFieldsJsonConverter.class)
  private CustomFields custom;

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
   * Gets sources.
   *
   * @return the sources
   */
  public Set<AssetSourceEntity> getSources() {
    return sources;
  }

  /**
   * Sets sources.
   *
   * @param sources the sources
   */
  public void setSources(Set<AssetSourceEntity> sources) {
    this.sources = sources;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public LocalizedString getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(LocalizedString name) {
    this.name = name;
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
   * Gets tags.
   *
   * @return the tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Sets tags.
   *
   * @param tags the tags
   */
  public void setTags(List<String> tags) {
    this.tags = tags;
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

  @Override
  public String toString() {
    return "AssetEntity{" +
        "id='" + id + '\'' +
        ", sources=" + sources +
        ", name=" + name +
        ", description=" + description +
        ", tags=" + tags +
        ", custom=" + custom +
        '}';
  }
}
