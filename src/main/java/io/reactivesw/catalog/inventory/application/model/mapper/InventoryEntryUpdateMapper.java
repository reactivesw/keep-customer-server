package io.reactivesw.catalog.inventory.application.model.mapper;

import com.google.common.collect.ImmutableMap;

import io.reactivesw.catalog.inventory.application.model.action.AddQuantityAction;
import io.reactivesw.catalog.inventory.application.model.action.AddReservedQuantityAction;
import io.reactivesw.catalog.inventory.application.model.action.RemoveQuantityAction;
import io.reactivesw.catalog.inventory.application.model.action.RemoveReservedQuantityAction;
import io.reactivesw.catalog.inventory.application.model.action.SetExpectedDelivery;
import io.reactivesw.catalog.inventory.application.model.action.SetQuantityAction;
import io.reactivesw.catalog.inventory.application.model.action.SetRestockableInDays;
import io.reactivesw.catalog.inventory.application.model.action.SetSupplyChannel;
import io.reactivesw.common.model.Update;

import java.util.Map;

/**
 * Created by Davis on 16/12/21.
 */
public interface InventoryEntryUpdateMapper<E> extends Update<E> {
  // TODO: 16/12/22  Set Custom Type, Set CustomField
  Map<Class<?>, InventoryEntryUpdateMapper> updateMappers = ImmutableMap.<Class<?>,
      InventoryEntryUpdateMapper>builder()
      .put(AddQuantityAction.class, new AddQuantityMapper())
      .put(RemoveQuantityAction.class, new RemoveQuantityMapper())
      .put(SetQuantityAction.class, new SetQuantityMappper())
      .put(SetRestockableInDays.class, new SetRestockableInDaysMapper())
      .put(SetExpectedDelivery.class, new SetExpectedDeliveryMapper())
      .put(SetSupplyChannel.class, new SetSupplyChannelMapper())
      .put(AddReservedQuantityAction.class, new AddReservedQuantityMapper())
      .put(RemoveReservedQuantityAction.class, new RemoveReservedQuantityMapper())
      .build();

  /**
   * @param clazz
   * @return
   */
  static InventoryEntryUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }
}
