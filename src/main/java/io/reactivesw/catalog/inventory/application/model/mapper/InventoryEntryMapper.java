package io.reactivesw.catalog.inventory.application.model.mapper;

import io.reactivesw.catalog.inventory.application.model.InventoryEntry;
import io.reactivesw.catalog.inventory.application.model.InventoryEntryDraft;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.common.enums.ReferenceTypes;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.mapper.CustomFieldsMapper;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Davis on 16/12/21.
 */
public final class InventoryEntryMapper {

  /**
   * private constructor.
   */
  private InventoryEntryMapper() {
  }

  /**
   * Model to entity inventory entry entity.
   *
   * @param model the model
   * @return the inventory entry entity
   */
  public static InventoryEntryEntity modelToEntity(InventoryEntryDraft model) {
    InventoryEntryEntity entity = new InventoryEntryEntity();

    entity.setSku(model.getSku());
    if (model.getSupplyChannel() != null) {
      entity.setSupplyChannel(model.getSupplyChannel().getId());
    }
    entity.setQuantityOnStock(model.getQuantityOnStock());
    entity.setRestockableInDays(model.getRestockableInDays());
    entity.setExpectedDelivery(model.getExpectedDelivery());
    if (model.getCustom() != null) {
      entity.setCustom(CustomFieldsMapper.modelToEntity(model.getCustom()));
    }
    /*
     * create an inventoryentry, availablequantity is same to quantityonstock.
     * Available amount of stock. (available means: quantityOnStock - reserved quantity)
     */
    entity.setAvailableQuantity(model.getQuantityOnStock());
    return entity;
  }

  /**
   * Entity to model inventory entry.
   *
   * @param entity the entity
   * @return the inventory entry
   */
  public static InventoryEntry entityToModel(InventoryEntryEntity entity) {
    InventoryEntry model = new InventoryEntry();

    model.setId(entity.getId());
    model.setSku(entity.getSku());
    model.setCustom(entity.getCustom());
    model.setQuantityOnStock(entity.getQuantityOnStock());
    model.setVersion(entity.getVersion());
    model.setRestockableInDays(entity.getRestockableInDays());
    model.setCreatedAt(entity.getCreatedAt());
    model.setLastModifiedAt(entity.getLastModifiedAt());
    model.setAvailableQuantity(entity.getAvailableQuantity());
    if (StringUtils.isNotBlank(entity.getSupplyChannel())) {
      model.setSupplyChannel(new Reference(ReferenceTypes.CHANNEL.getType(),
          entity.getSupplyChannel()));
    }

    model.setExpectedDelivery(entity.getExpectedDelivery());

    return model;
  }
}
