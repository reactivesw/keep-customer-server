package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/20.
 */
public final class TaxCategoryRouter extends BaseRouter {

  /**
   * tax category root.
   */
  public static final String TAX_CATEGORY_ROOT = URL_ROOT + "/tax-categories";

  /**
   * tax category id.
   */
  public static final String TAX_CATEGORY_ID = "taxCategoryId";

  /**
   * tax category with id.
   */
  public static final String TAX_CATEGORY_WITH_ID = TAX_CATEGORY_ROOT + "/{" + TAX_CATEGORY_ID +
      "}";

  /**
   * private default constructor.
   */
  private TaxCategoryRouter() {
    super();
  }

  /**
   * path builder: get tax category with id.
   *
   * @param id String
   * @return String
   */
  public static String getTaxCategoryWithId(String id) {
    return TAX_CATEGORY_ROOT + "/" + id;
  }
}
