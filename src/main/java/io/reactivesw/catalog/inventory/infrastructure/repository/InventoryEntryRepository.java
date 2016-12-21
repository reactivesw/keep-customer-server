package io.reactivesw.catalog.inventory.infrastructure.repository;

import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Davis on 16/12/21.
 */
public interface InventoryEntryRepository extends JpaRepository<InventoryEntryEntity, String> {
}
