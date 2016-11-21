package io.reactivesw.customer.server.catalog.models;

import io.reactivesw.customer.server.common.models.LocalizedString;

/**
 * Created by umasuo on 16/11/18.
 */
public class LocalizedEnumValue {

  /**
   * The key of the value used as a programmatic identifier, e.g. in facets & filters.
   */
  private String key;

  /**
   * A descriptive, localized label of the value.
   */
  private LocalizedString label;

}
