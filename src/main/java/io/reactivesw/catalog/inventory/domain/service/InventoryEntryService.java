package io.reactivesw.catalog.inventory.domain.service;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.inventory.application.model.InventoryEntry;
import io.reactivesw.catalog.inventory.application.model.InventoryEntryDraft;
import io.reactivesw.catalog.inventory.application.model.mapper.InventoryEntryMapper;
import io.reactivesw.catalog.inventory.application.model.mapper.InventoryEntryUpdateMapper;
import io.reactivesw.catalog.inventory.domain.entity.InventoryEntryEntity;
import io.reactivesw.catalog.inventory.infrastructure.repository.InventoryEntryRepository;
import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.UpdateAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

/**
 * Created by Davis on 16/12/21.
 */
@Service
public class InventoryEntryService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(InventoryEntryService.class);

  /**
   * The Inventory entry repository.
   */
  @Autowired
  private transient InventoryEntryRepository inventoryEntryRepository;

  /**
   * Create inventory entry inventory entry.
   *
   * @param draft the draft
   * @return the inventory entry
   */
  public InventoryEntry createInventoryEntry(InventoryEntryDraft draft) {
    LOG.debug("enter createInventoryEntry, inventory entry draft is : {}", draft.toString());

    InventoryEntryEntity entity = InventoryEntryMapper.modelToEntity(draft);
    InventoryEntryEntity savedEntity = inventoryEntryRepository.save(entity);

    InventoryEntry result = InventoryEntryMapper.entityToModel(savedEntity);

    LOG.debug("end createInventoryEntry, new InventoryEntry is : {}", result.toString());

    return result;
  }

  /**
   * Delete InventoryEntryEntity.
   *
   * @param id      the id
   * @param version the version
   */
  public void deleteInventoryEntry(String id, Integer version) {
    LOG.debug("enter deleteInventoryEntry, id is : {}, version is : {}", id, version);
    InventoryEntryEntity entity = getInventoryEntryEntity(id);
    validateVersion(entity, version);
    inventoryEntryRepository.delete(id);
    LOG.debug("end deleteInventoryEntry, id is : {}, version is : {}", id, version);
  }

  /**
   * Update InventoryEntry.
   *
   * @param id      the id
   * @param version the version
   * @param actions the actions
   * @return the inventory entry
   */
  @Transactional
  public InventoryEntry updateInventoryEntry(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter updateInventoryEntry, id is {}, version is {}, update action is {}",
        id, version, actions);

    InventoryEntryEntity entity = getInventoryEntryEntity(id);
    validateVersion(entity, version);

    actions.parallelStream().forEach(action -> {
      InventoryEntryUpdateMapper.getMapper(action.getClass())
          .handle(entity, action);
    });

    InventoryEntryEntity updatedEntity = inventoryEntryRepository.save(entity);
    //TODO send message, if slug be updated
    InventoryEntry result = InventoryEntryMapper.entityToModel(updatedEntity);

    LOG.debug("end updateInventoryEntry, updated InventoryEntry is {}", result);
    return result;
  }

  /**
   * Gets inventory entry by id.
   *
   * @param id the id
   * @return the inventory entry by id
   */
  public InventoryEntry getInventoryEntryById(String id) {
    LOG.debug("enter getInventoryEntryById, id is : {}", id);

    InventoryEntryEntity entity = getInventoryEntryEntity(id);

    InventoryEntry result = InventoryEntryMapper.entityToModel(entity);

    LOG.debug("end getInventoryEntryById, get result is : {}", result.toString());

    return result;
  }

  /**
   * Query by sku names.
   *
   * @param skuNames the sku names
   * @return the list
   */
  public List<InventoryEntry> queryBySkuNames(List<String> skuNames) {
    LOG.debug("enter queryBySkuNames, sku names is : {}", skuNames);
    List<InventoryEntryEntity> inventoryEntryEntities = inventoryEntryRepository.queryBySkuNames(skuNames);

    List<InventoryEntry> result = Lists.newArrayList();

    if (inventoryEntryEntities != null) {
      result = InventoryEntryMapper.entityToModel(inventoryEntryEntities);
    }

    LOG.debug("end queryBySkuNames, get InventoryEntries number is : {}", result.size());

    return result;
  }

  /**
   * Gets inventoryentry.
   *
   * @param id the id
   * @return the inventory entry entity
   */
  private InventoryEntryEntity getInventoryEntryEntity(String id) {
    InventoryEntryEntity entity = inventoryEntryRepository.findOne(id);
    if (entity == null) {
      LOG.debug("can not find inventoryentry by id : {}", id);
      throw new NotExistException("InventoryEntry Not Found");
    }
    return entity;
  }

  /**
   * validate version.
   * @param entity the entity
   * @param version the version
   */
  private void validateVersion(InventoryEntryEntity entity, Integer version) {
    if (!Objects.equals(version, entity.getVersion())) {
      LOG.debug("Version not match, input version:{}, entity version:{}",
          version, entity.getVersion());
      throw new ConflictException("Version not match");
    }
  }
}
