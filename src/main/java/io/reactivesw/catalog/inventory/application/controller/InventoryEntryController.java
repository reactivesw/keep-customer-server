package io.reactivesw.catalog.inventory.application.controller;

import static io.reactivesw.route.InventoryEntryRouter.INVENTORY_ENTRY_ID;
import static io.reactivesw.route.InventoryEntryRouter.INVENTORY_ENTRY_ROOT;
import static io.reactivesw.route.InventoryEntryRouter.INVENTORY_ENTRY_WITH_ID;

import io.reactivesw.catalog.inventory.application.model.InventoryEntry;
import io.reactivesw.catalog.inventory.application.model.InventoryEntryDraft;
import io.reactivesw.catalog.inventory.application.model.action.InventoryEntryUpdateAction;
import io.reactivesw.catalog.inventory.domain.service.InventoryEntryService;
import io.reactivesw.common.model.PagedQueryResult;
import io.reactivesw.common.model.UpdateRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

/**
 * Created by Davis on 16/12/21.
 */
@RestController
public class InventoryEntryController {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(InventoryEntryController.class);

  /**
   * The Inventory entry service.
   */
  @Autowired
  private transient InventoryEntryService inventoryEntryService;

  /**
   * Create inventory entry inventory entry.
   *
   * @param draft the draft
   * @return the inventory entry
   */
  @ApiOperation("create InventoryEntry")
  @PostMapping(INVENTORY_ENTRY_ROOT)
  public InventoryEntry createInventoryEntry(@RequestBody
                                             @ApiParam(value = "InventoryEntry Draft",
                                                 required = true)
                                             @Valid InventoryEntryDraft draft) {
    LOG.debug("enter createInventoryEntry, inventory entry draft is : {}", draft.toString());

    InventoryEntry result = inventoryEntryService.createInventoryEntry(draft);

    LOG.debug("end createInventoryEntry, new InventoryEntry is : {}", result.toString());

    return result;
  }

  /**
   * Delete inventory entry.
   *
   * @param id      the id
   * @param version the version
   */
  @ApiOperation("delete InventoryEntry")
  @DeleteMapping(INVENTORY_ENTRY_WITH_ID)
  public void deleteInventoryEntry(@PathVariable(value = INVENTORY_ENTRY_ID)
                                   @ApiParam(value = "InventoryEntry Id", required = true)
                                       String id,
                                   @RequestParam
                                   @ApiParam(value = "InventoryEntry Version", required = true)
                                       Integer version) {
    LOG.debug("enter deleteInventoryEntry, id is : {}, version is : {}", id, version);

    inventoryEntryService.deleteInventoryEntry(id, version);

    LOG.debug("end deleteInventoryEntry, id is : {}, version is : {}", id, version);
  }

  /**
   * Update InventoryEntry.
   *
   * @param id            the id
   * @param updateRequest the update request
   * @return the inventory entry
   */
  @ApiOperation(value = "Update InventoryEntry")
  @PutMapping(INVENTORY_ENTRY_WITH_ID)
  public InventoryEntry updateInventoryEntry(@PathVariable(value = INVENTORY_ENTRY_ID)
                                             @ApiParam(value = "InventoryEntry ID", required = true)
                                                 String id,
                                             @RequestBody
                                             @ApiParam(value = "InventoryEntry Update Request",
                                                 required = true)
                                                 UpdateRequest<InventoryEntryUpdateAction>
                                                 updateRequest) {
    LOG.debug("enter updateInventoryEntry, id is {}, update InventoryEntry is {}",
        id, updateRequest.toString());

    InventoryEntry result = inventoryEntryService.updateInventoryEntry(id,
        updateRequest.getVersion(), updateRequest.getActions());

    LOG.debug("end updateInventoryEntry, updated InventoryEntry is {}", result.toString());

    return result;
  }

  /**
   * Gets inventory entry by id.
   *
   * @param id the id
   * @return the inventory entry by id
   */
  @ApiOperation("get InventoryEntry by Id")
  @GetMapping(INVENTORY_ENTRY_WITH_ID)
  public InventoryEntry getInventoryEntryById(@PathVariable(value = INVENTORY_ENTRY_ID)
                                              @ApiParam(value = "InventoryEntry ID",
                                                  required = true)
                                                  String id) {
    LOG.debug("enter getInventoryEntryById, id is : {}", id);

    InventoryEntry result = inventoryEntryService.getInventoryEntryById(id);

    LOG.debug("end getInventoryEntryById, get result is : {}", result.toString());

    return result;
  }

  /**
   * Query inventory entries by sku names.
   *
   * @param skuNames the sku names
   * @return the paged query result
   */
  @ApiOperation("query InventoryEntries by Sku names")
  @GetMapping(INVENTORY_ENTRY_ROOT)
  public PagedQueryResult<InventoryEntry> queryInventoryEntriesBySkuNames(@RequestParam("skuNames")
                                                                              List<String>
                                                                              skuNames) {
    LOG.debug("enter queryInventoryEntriesBySkuNames, query conditions is : {}", skuNames);

    List<InventoryEntry> inventoryEntries = inventoryEntryService.queryBySkuNames(skuNames);
    PagedQueryResult<InventoryEntry> result = new PagedQueryResult<>();
    result.setTotal(inventoryEntries.size());
    result.setResults(inventoryEntries);
    LOG.debug("end queryInventoryEntriesBySkuNames, get InventoryEntries number is : {}",
        inventoryEntries.size());

    return result;
  }
}
