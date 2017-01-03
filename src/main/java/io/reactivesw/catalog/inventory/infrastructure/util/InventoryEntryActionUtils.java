package io.reactivesw.catalog.inventory.infrastructure.util;

/**
 * Created by Davis on 17/1/3.
 */
public final class InventoryEntryActionUtils {
  /**
   * Instantiates a new Inventory entry action utils.
   */
  private InventoryEntryActionUtils() {}

  /**
   * The constant INVENTORY_ENTRY_ROOT.
   */
  private static final String INVENTORY_ENTRY_ROOT = "inventory_entry_";

  /**
   * The constant add_quantity.
   */
  public static final String ADD_QUANTITY = INVENTORY_ENTRY_ROOT + "add_quantity";


  /**
   * The constant remove_quantity.
   */
  public static final String REMOVE_QUANTITY = INVENTORY_ENTRY_ROOT + "remove_quantity";

  /**
   * The constant add_reserved_quantity.
   */
  public static final String ADD_RESERVED_QUANTITY = INVENTORY_ENTRY_ROOT + "add_reserved_quantity";

  /**
   * The constant remove_reserved_quantity.
   */
  public static final String REMOVE_RESERVED_QUANTITY = INVENTORY_ENTRY_ROOT +
      "remove_reserved_quantity";

  /**
   * The constant set_expected_delivery.
   */
  public static final String SET_EXPECTED_DELIVERY = INVENTORY_ENTRY_ROOT + "set_expected_delivery";

  /**
   * The constant set_quantity.
   */
  public static final String SET_QUANTITY = INVENTORY_ENTRY_ROOT + "set_quantity";

  /**
   * The constant set_restockable_in_days.
   */
  public static final String SET_RESTOCKABLE_IN_DAYS = INVENTORY_ENTRY_ROOT +
      "set_restockable_in_days";

  /**
   * The constant set_supply_channel.
   */
  public static final String SET_SUPPLY_CHANNEL = INVENTORY_ENTRY_ROOT + "set_supply_channel";

}
