package io.reactivesw.catalog.taxcategory.application.controller;

import static io.reactivesw.route.TaxCategoryRouter.TAX_CATEGORY_ID;
import static io.reactivesw.route.TaxCategoryRouter.TAX_CATEGORY_ROOT;
import static io.reactivesw.route.TaxCategoryRouter.TAX_CATEGORY_WITH_ID;

import io.reactivesw.catalog.taxcategory.application.model.TaxCategory;
import io.reactivesw.catalog.taxcategory.application.model.TaxCategoryDraft;
import io.reactivesw.catalog.taxcategory.domain.service.TaxCategoryService;
import io.reactivesw.common.model.PagedQueryResult;
import io.reactivesw.common.model.QueryConditions;
import io.reactivesw.common.model.UpdateRequest;
import io.swagger.annotations.ApiModel;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;


/**
 * Created by Davis on 16/12/10.
 */
@ApiModel
@RestController
public class TaxCategoryController {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(TaxCategoryController.class);

  /**
   * TaxCategoryService.
   */
  @Autowired
  private transient TaxCategoryService taxCategoryService;


  /**
   * Create tax category.
   *
   * @param draft the TaxCategoryDraft
   * @return the TaxCategory
   */
  @ApiOperation(value = "Create TaxCategory")
  @PostMapping(TAX_CATEGORY_ROOT)
  public TaxCategory createTaxCategory(@RequestBody
                                       @ApiParam(value = "TaxCategory Draft", required = true)
                                           TaxCategoryDraft draft) {
    LOG.debug("enter createTaxCategory, TaxCategoryDraft is : {}", draft.toString());

    TaxCategory result = taxCategoryService.createTaxCategory(draft);

    LOG.debug("end createTaxCategory, new TaxCategory is : {}", result.toString());

    return result;
  }

  /**
   * Delete TaxCategory.
   *
   * @param id      the id
   * @param version the version
   */
  @ApiOperation(value = "Delete TaxCategory By Id")
  @DeleteMapping(value = TAX_CATEGORY_WITH_ID)
  public void deleteTaxCategory(@PathVariable(value = TAX_CATEGORY_ID)
                                @ApiParam(value = "TaxCategory ID", required = true)
                                    String id,
                                @ApiParam(value = "TaxCategory Version", required = true)
                                @NotNull
                                    Integer version) {

    LOG.debug("enter deleteProduct, id is {}, version is {}", id, version);


    LOG.debug("end deleteProduct, id is {}, version is {}", id, version);
  }


  /**
   * Update TaxCategory.
   *
   * @param id            the id
   * @param updateRequest the update request
   * @return the TaxCategory
   */
  @ApiOperation(value = "Update TaxCategory")
  @PutMapping(TAX_CATEGORY_WITH_ID)
  public TaxCategory updateTaxCategory(@PathVariable(value = TAX_CATEGORY_ID)
                                       @ApiParam(value = "TaxCategory ID", required = true)
                                           String id,
                                       @RequestBody
                                       @ApiParam(value = "TaxCategory Update Fields",
                                           required = true)
                                           UpdateRequest updateRequest) {
    LOG.debug("enter updateTaxCategory, id is : {}, update request is : {}", id,
        updateRequest.toString());

    TaxCategory result = taxCategoryService.updateTaxCategory(id, updateRequest.getVersion(),
        updateRequest.getActions());

    LOG.debug("end updateTaxCategory, updated TaxCategory is : {}", result.toString());

    return result;
  }

  /**
   * Gets TaxCategory by id.
   *
   * @param id the id
   * @return the TaxCategory
   */
  @ApiOperation(value = "Get TaxCategory By Id")
  @GetMapping(TAX_CATEGORY_WITH_ID)
  public TaxCategory getTaxCategoryById(@PathVariable(value = TAX_CATEGORY_ID)
                                        @ApiParam(value = "TaxCategory ID", required = true)
                                            String id) {
    LOG.debug("enter getTaxCategoryById, id is : {}", id);

    TaxCategory result = taxCategoryService.getTaxCategoryById(id);

    LOG.debug("end getTaxCategoryById, TaxCategory is : {}", result.toString());

    return result;
  }

  /**
   * Query tax categories.
   *
   * @param queryConditions the query conditions
   * @return the paged query result
   */
  @ApiOperation(value = "query TaxCategories")
  @GetMapping(TAX_CATEGORY_ROOT)
  public PagedQueryResult<TaxCategory> queryTaxCategories(QueryConditions queryConditions) {
    LOG.debug("enter queryTaxCategories, queryConditions is : {}", queryConditions.toString());

    PagedQueryResult result = taxCategoryService.queryTaxCategories(queryConditions);

    LOG.debug("end queryTaxCategories, find TaxCategory is : {}", result.toString());

    return result;
  }
}
