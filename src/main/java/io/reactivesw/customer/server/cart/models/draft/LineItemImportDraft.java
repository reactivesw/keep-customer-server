package io.reactivesw.customer.server.cart.models.draft;

import io.reactivesw.customer.server.cart.models.ItemState;
import io.reactivesw.customer.server.catalog.models.Price;
import io.reactivesw.customer.server.common.types.LocalizedString;
import io.reactivesw.customer.server.common.types.Reference;
import io.reactivesw.customer.server.common.types.TaxRate;
import io.reactivesw.customer.server.common.types.draft.CustomFieldsDraft;

import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class LineItemImportDraft {

  /**
   * ID of the existing product.
   * You also need to specify the ID of the variant if this property is set or alternatively
   * you can just specify SKU of the product variant.
   */
  private String productId;

  /**
   * The product name.
   */
  private LocalizedString name;

  /**
   * The Variant.
   */
  private ProductVariantImportDraft variant;

  /**
   * The Price.
   */
  private Price price;

  /**
   * The Quantity.
   */
  private Integer quantity;

  /**
   * Array of ItemState.
   * Optional.
   */
  private List<ItemState> state;

  /**
   * Reference to a Channel.
   * Optional connection to particular supplier.
   * By providing supply channel information,
   * you can unique identify inventory entries that should be reserved.
   * Provided channel should have role InventorySupply.
   * Optional.
   */
  private Reference supplyChannel;


  /**
   * The Tax rate.
   */
  private TaxRate taxRate;

  /**
   * The custom fields.
   */
  private CustomFieldsDraft custom;
}
