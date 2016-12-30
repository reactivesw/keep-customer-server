package io.reactivesw.catalog.producttype.infrastructure.util;

/**
 * Created by Davis on 16/12/30.
 */
public final class ProductActionUtils {
  /**
   * Instantiates a new Product action utils.
   */
  private ProductActionUtils() {
  }

  /**
   * root name.
   */
  private static final String PRODUCT_TYPE_ROOT = "product_type_";

  /**
   * The constant SET_KEY.
   */
  public static final String SET_KEY = PRODUCT_TYPE_ROOT + "set_key";

  /**
   * The constant SET_NAME.
   */
  public static final String SET_NAME = PRODUCT_TYPE_ROOT + "set_name";

  /**
   * The constant SET_DESCRIPTION.
   */
  public static final String SET_DESCRIPTION = PRODUCT_TYPE_ROOT + "set_description";

  /**
   * The constant add_attribute_definition.
   */
  public static final String ADD_ATTRIBUTE_DEFINITION = PRODUCT_TYPE_ROOT +
      "add_attribute_definition";

  /**
   * The constant remove_attribute_definition.
   */
  public static final String REMOVE_ATTRIBUTE_DEFINITION = PRODUCT_TYPE_ROOT +
      "remove_attribute_definition";

  /**
   * The constant set_attribute_definition.
   */
  public static final String SET_ATTRIBUTE_DEFINITION = PRODUCT_TYPE_ROOT + "set_attribute_label";

  /**
   * The constant set_attribute_definition_inputtip.
   */
  public static final String SET_ATTRIBUTE_DEFINITION_INPUTTIP = PRODUCT_TYPE_ROOT +
      "set_attribute_definition_inputtip";

  /**
   * The constant add_plain_enum_value.
   */
  public static final String ADD_PLAIN_ENUM_VALUE = PRODUCT_TYPE_ROOT + "add_plain_enum_value";

  /**
   * The constant add_localized_enum_value.
   */
  public static final String ADD_LOCALIZED_ENUM_VALUE = PRODUCT_TYPE_ROOT +
      "add_localized_enum_value";

  /**
   * The constant set_Attribute_Order.
   */
  public static final String SET_ATTRIBUTE_ORDER = PRODUCT_TYPE_ROOT + "set_attribute_order";

  /**
   * The constant set_enum_value_order.
   */
  public static final String SET_ENUM_VALUE_ORDER = PRODUCT_TYPE_ROOT + "set_enum_value_order";

  /**
   * The constant set_localized_enum_value_order.
   */
  public static final String SET_LOCALIZED_ENUM_VALUE_ORDER = PRODUCT_TYPE_ROOT +
      "set_localized_enum_value_order";

  /**
   * The constant set_enum_value_label.
   */
  public static final String SET_ENUM_VALUE_LABEL = PRODUCT_TYPE_ROOT + "set_enum_value_label";

  /**
   * The constant set_localized_enum_value_label.
   */
  public static final String SET_LOCALIZED_ENUM_VALUE_LABEL = PRODUCT_TYPE_ROOT +
      "set_localized_enum_value_label";

  /**
   * The constant set_attribute_definition_is_searchable.
   */
  public static final String SET_ATTRIBUTE_DEFINITION_IS_SEARCHABLE = PRODUCT_TYPE_ROOT +
      "set_attribute_definition_is_searchable";
}
