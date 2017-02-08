package io.reactivesw.catalog.inventory.infrastructure.util;

import io.reactivesw.catalog.inventory.application.model.InventoryRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Davis on 17/2/8.
 */
public final class InventoryRequestUtils {
  /**
   * Instantiates a new Inventory request utils.
   */
  private InventoryRequestUtils() {
  }

  /**
   * Gets sku names.
   *
   * @param requests the requests
   * @return the sku names
   */
  public static List<String> getSkuNames(List<InventoryRequest> requests) {
    return requests.parallelStream().map(
        request -> {
          return request.getSkuName();
        }
    ).collect(Collectors.toList());
  }

  public static Map<String, Integer> getSkuQuantityMap(List<InventoryRequest> requests) {
    return requests.parallelStream().collect(
        Collectors.toMap(InventoryRequest::getSkuName, InventoryRequest::getQuantity)
    );
  }
}
