package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/20.
 */
public final class ProductRouter extends BaseRouter {

  /**
   * product root.
   */
  public static final String PRODUCT_ROOT = URL_ROOT + "/products";

  /**
   * product id.
   */
  public static final String PRODUCT_ID = "productId";

  /**
   * product with id.
   */
  public static final String PRODUCT_WITH_ID = PRODUCT_ROOT + "/{" + PRODUCT_ID + "}";


  /**
   * The constant PRODUCT_SLUG.
   */
  public static final String PRODUCT_SLUG = "productSlug";

  /**
   * The constant PRODUCT_WITH_SLUG.
   */
  public static final String PRODUCT_WITH_SLUG = PRODUCT_ROOT + "/{" + PRODUCT_SLUG + "}";

  /**
   * private default constructor.
   */
  private ProductRouter() {
    super();
  }

  /**
   * path builder: get product by id.
   *
   * @param id String
   * @return String
   */
  public static String getProductWithId(String id) {
    return PRODUCT_ROOT + "/" + id;
  }
}
