package io.reactivesw.catalog.product.infrastructure.util;

import io.reactivesw.catalog.inventory.application.model.InventoryEntry;
import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.product.application.model.ProductData;
import io.reactivesw.catalog.product.application.model.ProductVariant;
import io.reactivesw.catalog.product.application.model.mapper.ProductVariantAvailabilityMapper;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by Davis on 16/12/22.
 */
public final class ProductInventoryUtils {

  /**
   * Instantiates a new Product inventory util.
   */
  private ProductInventoryUtils() {}

  /**
   * Merge inventory entry to product.
   *
   * @param inventoryEntries the inventory entries
   * @param product          the product
   * @return the product
   */
  public static Product mergeInventoryEntryToProduct(List<InventoryEntry> inventoryEntries, Product
      product) {
    ProductData currentData = product.getMasterData().getCurrent();
    ProductVariant masterVariant = currentData.getMasterVariant();
    mergeInventoryEntryToVariant(inventoryEntries, masterVariant);

    if (currentData.getVariants() != null && !currentData.getVariants().isEmpty()) {
      currentData.getVariants().parallelStream().forEach(
          variant -> {
            mergeInventoryEntryToVariant(inventoryEntries, variant);
          }
      );
    }

    return product;
  }

  /**
   * merge InventoryEntry to ProductVariant.
   * @param inventoryEntries the InventoryEntry
   * @param variant the ProductVariant
   */
  private static void mergeInventoryEntryToVariant(List<InventoryEntry> inventoryEntries,
                                                   ProductVariant variant) {
    inventoryEntries.stream().forEach(
        entry -> {
          if (StringUtils.equals(entry.getSku(), variant.getSku())) {
            variant.setAvailability(ProductVariantAvailabilityMapper.toModel(entry));
          }
        }
    );
  }
}
