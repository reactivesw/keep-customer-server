package io.reactivesw.catalog.producttype.application.controller;

import static io.reactivesw.route.Router.PRODUCT_TYPE_ROOT;

import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.catalog.producttype.application.model.ProductTypeDraft;
import io.reactivesw.catalog.producttype.domain.service.ProductTypeService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
  @ApiOperation(value = "Create ProductType")
  @PostMapping(PRODUCT_TYPE_ROOT)
  public ProductType createProductType(@RequestBody
                                       @ApiParam(value = "ProductType Draft", required = true)
                                           ProductTypeDraft productTypeDraft) {
    LOG.debug("enter createProductType, draft is:{}", productTypeDraft.toString());

    ProductType result = productTypeService.createProductType(productTypeDraft);

    LOG.debug("end createProductType, new product type is:{}", result.toString());

    return result;
  }
}
