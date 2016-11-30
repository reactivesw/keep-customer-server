package io.reactivesw.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/16.
 */
@Entity
@Table(name = "common_localized_String")
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

  /**
   * Gets language.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Sets language.
   *
   * @param language the language
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * Gets text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets text.
   *
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "LocalizedStringEntity{"
            + "id=" + id
            + "language='" + language + '\''
            + ", text='" + text + '\''
            + '}';
  }
}
