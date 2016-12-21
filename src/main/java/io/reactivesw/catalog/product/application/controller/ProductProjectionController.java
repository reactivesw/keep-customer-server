package io.reactivesw.catalog.product.application.controller;

import static io.reactivesw.route.ProductProjectionRouter.PRODUCT_PROJECTION_ROOT;

import io.reactivesw.catalog.product.application.ProductApplication;
import io.reactivesw.catalog.product.application.model.ProductProjection;
import io.reactivesw.common.model.PagedQueryResult;
import io.reactivesw.common.model.QueryConditions;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Davis on 16/12/21.
 */
@RestController
public class ProductProjectionController {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ProductProjectionController.class);

  /**
   * The Product application.
   */
  @Autowired
  private transient ProductApplication productApplication;

  /**
   * Query product projections list.
   *
   * @param queryConditions the query conditions
   * @return the list
   */
  // TODO: 16/12/21 only for query product by category now
  @ApiOperation("")
  @GetMapping(PRODUCT_PROJECTION_ROOT)
  public PagedQueryResult<ProductProjection> queryProductProjections(QueryConditions queryConditions) {
    LOG.debug("enter queryProductProjections, query conditions is : {}",
        queryConditions.toString());

    PagedQueryResult<ProductProjection> result = new PagedQueryResult<>();
    List<ProductProjection> productProjections =
        productApplication.queryProductProject(queryConditions);
    result.setTotal(productProjections.size());
    result.setResults(productProjections);
    LOG.debug("end queryProductProjections, product projections number is : {}",
        productProjections.size());

    return result;
  }
}
