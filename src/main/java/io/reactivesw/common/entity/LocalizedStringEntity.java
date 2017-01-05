package io.reactivesw.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/16.
 */
@Entity
@Table(name = "common_localized_String")
@Data
@EqualsAndHashCode(callSuper = false)
public class LocalizedStringEntity extends BaseIdEntity {

  /**
   * language.
   */
  @Column
  protected String language;

  /**
   * text value.
   */
  @Column(columnDefinition = "text")
  protected String text;

  /**
   * Instantiates a new Localized string entity.
   */
  public LocalizedStringEntity() {
    super();
  }

  /**
   * Instantiates a new Localized string entity.
   *
   * @param language the language
   * @param text     the text
   */
  public LocalizedStringEntity(String language, String text) {
    this.language = language;
    this.text = text;
  }

}
