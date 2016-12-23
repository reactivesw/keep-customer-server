package io.reactivesw.catalog.product.application;

import io.reactivesw.catalog.inventory.application.model.InventoryEntry;
import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.ProductProjection;
import io.reactivesw.catalog.product.application.model.mapper.ProductProjectionMapper;
import io.reactivesw.catalog.product.domain.entity.ProductEntity;
import io.reactivesw.catalog.product.domain.service.ProductService;
import io.reactivesw.catalog.product.infrastructure.utils.ProductInventoryUtils;
import io.reactivesw.catalog.product.infrastructure.utils.QueryConditionUtils;
import io.reactivesw.catalog.product.infrastructure.validator.AttributeConstraintValidator;
import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.QueryConditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Davis on 16/12/18.
 */
@Service
public class ProductApplication {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ProductApplication.class);

  /**
   * ProductRestClient.
   */
  @Autowired
  private transient ProductRestClient productRestClient;

  /**
   * product service.
   */
  @Autowired
  private transient ProductService productService;

  /**
   * Create product product.
   *
   * @param productDraft the product draft
   * @return the product
   */
  public Product createProduct(ProductDraft productDraft) {
    LOG.debug("enter createProduct, product draft is : {}", productDraft.toString());

    String productTypeId = productDraft.getProductType().getId();

    ProductType productType = productRestClient.getProductType(productTypeId);

    if (productType == null) {
      LOG.debug("can not find product type by id : {}", productTypeId);
      throw new NotExistException("ProductType Not Found");
    }

    AttributeConstraintValidator.validate(productType.getAttributes(), productDraft);

    Product result = productService.createProduct(productDraft);

    LOG.debug("end createProduct, new product is : {}", result.toString());

    return result;
  }

  /**
   * Get prodcut by id.
   *
   * @param id the id
   * @return the product
   */
  public Product getProductById(String id) {
    LOG.debug("enter getProductById, the id is : {}", id);

    Product result = productService.getProductById(id);

    List<InventoryEntry> inventoryEntries = productRestClient.getInventoryEntry(result);

    if (inventoryEntries != null && inventoryEntries.isEmpty()) {
      result = ProductInventoryUtils.mergeInventoryEntryToProduct(inventoryEntries, result);
    }

    LOG.debug("end getProductById, the product is : {}", result.toString());

    return result;
  }

  /**
   * Query product project list.
   * TODO: 16/12/21 only for query product by category now.
   * query example:
   * categoryId:"1234567890"
   *
   * @param queryConditions the query conditions
   * @return the list
   */
  public List<ProductProjection> queryProductProject(QueryConditions queryConditions) {
    LOG.debug("enter queryProductProjections, query conditions is : {}",
        queryConditions.toString());

    String categoryId = QueryConditionUtils.getCategoryId(queryConditions);

    List<ProductEntity> productEntities = productService.queryProductByCategory(categoryId);

    List<ProductProjection> result = ProductProjectionMapper.entityToModel(productEntities);

    LOG.debug("end queryProductProjections, product projections number is : {}", result.size());

    return result;
  }
}