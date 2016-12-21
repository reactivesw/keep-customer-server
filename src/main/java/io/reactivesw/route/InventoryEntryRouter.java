package io.reactivesw.route;

/**
 * Created by Davis on 16/12/21.
 */
public class InventoryEntryRouter extends BaseRouter {

  /**
   * inventory_entry root.
   */
  public static final String INVENTORY_ENTRY_ROOT = URL_ROOT + "/inventory";

  /**
   * inventory_entry id.
   */
  public static final String INVENTORY_ENTRY_ID = "inventoryId";

  /**
   * inventory_entry with id.
   */
  public static final String INVENTORY_ENTRY_WITH_ID = INVENTORY_ENTRY_ROOT
      + "/{" + INVENTORY_ENTRY_ID + "}";
}
