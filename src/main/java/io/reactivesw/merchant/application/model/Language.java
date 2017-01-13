package io.reactivesw.merchant.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by Davis on 17/1/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Language {
  /**
   * The Language code.
   */
  private String languageCode;

  /**
   * The Name.
   */
  private String name;

  /**
   * The Native name.
   */
  private String nativeName;
}
