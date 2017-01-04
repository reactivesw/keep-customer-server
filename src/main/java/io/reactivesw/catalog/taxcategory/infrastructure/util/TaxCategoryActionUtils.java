package io.reactivesw.catalog.taxcategory.infrastructure.util;

/**
 * Created by Davis on 17/1/3.
 */
public final class TaxCategoryActionUtils {
  /**
   * Instantiates a new Tax category action utils.
   */
  private TaxCategoryActionUtils() {
  }

  /**
   * The constant Tax_Category_root.
   */
  private static final String TAX_CATEGORY_ROOT = "tax_category_";

  /**
   * The constant set_name.
   */
  public static final String SET_NAME = TAX_CATEGORY_ROOT + "set_name";

  /**
   * The constant set_description.
   */
  public static final String SET_DESCRIPTION = TAX_CATEGORY_ROOT + "set_description";

  /**
   * The constant add_tax_rate.
   */
  public static final String ADD_TAX_RATE = TAX_CATEGORY_ROOT + "add_tax_rate";

  /**
   * The constant replace_tax_rate.
   */
  public static final String REPLACE_TAX_RATE = TAX_CATEGORY_ROOT + "replace_tax_rate";

  /**
   * The constant remove_tax_rate.
   */
  public static final String REMOVE_TAX_RATE = TAX_CATEGORY_ROOT + "remove_tax_rate";
}
