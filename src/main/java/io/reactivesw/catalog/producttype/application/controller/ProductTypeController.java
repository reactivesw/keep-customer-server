package io.reactivesw.catalog.producttype.application.controller;

import static io.reactivesw.route.ProductTypeRouter.PRODUCT_TYPE_ID;
import static io.reactivesw.route.ProductTypeRouter.PRODUCT_TYPE_KEY;
import static io.reactivesw.route.ProductTypeRouter.PRODUCT_TYPE_ROOT;
import static io.reactivesw.route.ProductTypeRouter.PRODUCT_TYPE_WITH_ID;
import static io.reactivesw.route.ProductTypeRouter.PRODUCT_TYPE_WITH_KEY;

import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.catalog.producttype.application.model.ProductTypeDraft;
import io.reactivesw.catalog.producttype.domain.service.ProductTypeService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Davis on 16/12/7.
 */
@ApiModel
@RestController
public class ProductTypeController {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ProductTypeController.class);

  /**
   * PRODUCT_TYPE_ID_STRING.
   */
  private static final String PRODUCT_TYPE_ID_STRING = "ProductType ID";

  /**
   * The Product type service.
   */
  @Autowired
  private transient ProductTypeService productTypeService;

  /**
   * Create product type product type.
   *
   * @param productTypeDraft the product type draft
   * @return the product type
   */
  @ApiOperation("Create ProductType")
  @PostMapping(PRODUCT_TYPE_ROOT)
  public ProductType createProductType(@RequestBody
                                       @ApiParam(value = "ProductType Draft", required = true)
                                       @Valid ProductTypeDraft productTypeDraft) {
    LOG.debug("enter createProductType, draft is:{}", productTypeDraft.toString());

    ProductType result = productTypeService.createProductType(productTypeDraft);

    LOG.debug("end createProductType, new product type is:{}", result.toString());

    return result;
  }

  /**
   * Delete ProductType by id.
   *
   * @param id      the id
   * @param version the version
   */
  @ApiOperation(value = "Delete ProductType By Id")
  @DeleteMapping(PRODUCT_TYPE_WITH_ID)
  public void deleteProductTypeById(@PathVariable(value = PRODUCT_TYPE_ID)
                                    @ApiParam(value = PRODUCT_TYPE_ID_STRING, required = true)
                                        String id,
                                    @RequestParam
                                    @ApiParam(value = "ProductType Version", required = true)
                                    @NotNull Integer version) {
    LOG.debug("enter deleteProductTypeById, id is : {}, version is : {}", id, version);

    productTypeService.deleteProductTypeById(id, version);

    LOG.debug("end deleteProductTypeById, id is : {}, version is : {}", id, version);
  }

  /**
   * Delete ProductType by key.
   *
   * @param key     the id
   * @param version the version
   */
  @ApiOperation(value = "Delete ProductType By Key")
  @DeleteMapping(PRODUCT_TYPE_WITH_KEY)
  public void deleteProductTypeByKey(@PathVariable(value = PRODUCT_TYPE_KEY)
                                     @ApiParam(value = "ProductType Key", required = true)
                                         String key,
                                     @RequestParam
                                     @ApiParam(value = "ProductType Version", required = true)
                                     @NotNull Integer version) {
    LOG.debug("enter deleteProductTypeById, key is : {}, version is : {}", key, version);

    productTypeService.deleteProductTypeByKey(key, version);

    LOG.debug("end deleteProductTypeById, key is : {}, version is : {}", key, version);
  }


  /**
   * Update ProductType by id.
   *
   * @param id            the id
   * @param updateRequest the update request
   * @return the ProductType
   */
  @ApiOperation(value = "UpdateProductType By Id")
  @PutMapping(PRODUCT_TYPE_WITH_ID)
  public ProductType updateProductTypeById(@PathVariable(value = PRODUCT_TYPE_ID)
                                           @ApiParam(value = PRODUCT_TYPE_ID_STRING,
                                               required = true)
                                               String id,
                                           @RequestBody
                                           @ApiParam(value = "ProductType Update Fields",
                                               required = true)
                                               UpdateRequest updateRequest) {
    LOG.debug("enter updateProductTypeById,id is {}, update request is {}",
        id, updateRequest.toString());

    ProductType result = productTypeService.updateProductTypeById(id, updateRequest.getVersion(),
        updateRequest.getActions());

    LOG.debug("end updateCategory, updated Category is {}", result.toString());

    return result;
  }

  /**
   * Update ProductType by key.
   *
   * @param key           the key
   * @param updateRequest the update request
   * @return the ProductType
   */
  @ApiOperation(value = "UpdateProductType By key")
  @PutMapping(PRODUCT_TYPE_WITH_KEY)
  public ProductType updateProductTypeByKey(@PathVariable(value = PRODUCT_TYPE_ID)
                                            @ApiParam(value = PRODUCT_TYPE_ID_STRING,
                                                required = true)
                                                String key,
                                            @RequestBody
                                            @ApiParam(value = "ProductType Update Fields",
                                                required = true)
                                                UpdateRequest updateRequest) {
    LOG.debug("enter updateProductTypeById,key is {}, update request is {}",
        key, updateRequest.toString());

    ProductType result = productTypeService.updateProductTypeByKey(key, updateRequest.getVersion(),
        updateRequest.getActions());

    LOG.debug("end updateCategory, updated Category is {}", result.toString());

    return result;
  }

  /**
   * Gets ProductType by id.
   *
   * @param id the id
   * @return the product type
   */
  @ApiOperation(value = "get ProductType by id")
  @GetMapping(PRODUCT_TYPE_WITH_ID)
  public ProductType getProductTypeById(@PathVariable(value = PRODUCT_TYPE_ID)
                                        @ApiParam(value = PRODUCT_TYPE_ID_STRING, required = true)
                                            String id) {
    LOG.debug("enter getProductTypeById, id is:{}", id);
    ProductType result = productTypeService.getProductTypeById(id);
    LOG.debug("end getProductTypeById, get ProductType : {}", result.toString());
    return result;
  }

  /**
   * Gets ProductType by key.
   *
   * @param key the key
   * @return the product type
   */
  @ApiOperation(value = "get ProductType by key")
  @GetMapping(PRODUCT_TYPE_WITH_KEY)
  public ProductType getProductTypeByKey(@PathVariable(value = PRODUCT_TYPE_KEY)
                                         @ApiParam(value = "ProductTyle key", required = true)
                                             String key) {
    LOG.debug("enter getProductTypeByKey, key is : {}", key);

    ProductType result = productTypeService.getProductTypeByKey(key);

    LOG.debug("end getProductTypeById, get ProductType : {}", result.toString());

    return result;
  }

  /**
   * Query ProductType.
   *
   * @param queryConditions the query conditions
   * @return the paged query result
   */
  @ApiOperation(value = "query ProductType")
  @GetMapping(PRODUCT_TYPE_ROOT)
  public PagedQueryResult<ProductType> queryProductTypes(QueryConditions queryConditions) {
    LOG.debug("enter queryProductTypes, QueryConditions is : {}", queryConditions.toString());

    PagedQueryResult<ProductType> result = productTypeService.queryProductTypes(queryConditions);

    LOG.debug("end queryProductTypes, productType number is : {}", result.getResults().size());

    return result;
  }
}
