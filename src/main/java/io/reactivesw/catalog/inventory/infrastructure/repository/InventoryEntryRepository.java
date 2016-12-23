package io.reactivesw.catalog.inventory.infrastructure.repository;

import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Davis on 16/12/21.
 */
public interface InventoryEntryRepository extends JpaRepository<InventoryEntryEntity, String> {
  @Query(value = "select i from InventoryEntryEntity i where i.sku in ?1")
  List<InventoryEntryEntity> queryBySkuNames(List<String> skuNames);
}
