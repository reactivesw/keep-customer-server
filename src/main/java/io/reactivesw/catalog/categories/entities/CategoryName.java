package io.reactivesw.catalog.categories.entities;

import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.models.LocalizedString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Davis on 16/11/30.
 */
@Entity
@Table(name = "catalog_category_name")
public class CategoryName extends LocalizedStringEntity{
  /**
   * Instantiates a new Category name.
   */
  public CategoryName() {
  }

  /**
   * Instantiates a new Category name.
   *
   * @param language the language
   * @param text     the text
   */
  public CategoryName(String language, String text){
    super(language, text);
  }
}
