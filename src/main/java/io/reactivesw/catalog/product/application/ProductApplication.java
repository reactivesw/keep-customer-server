package io.reactivesw.catalog.product.application;

import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.ProductProjection;
import io.reactivesw.catalog.product.application.model.mapper.ProductProjectionMapper;
import io.reactivesw.catalog.product.domain.entity.ProductEntity;
import io.reactivesw.catalog.product.domain.service.ProductService;
import io.reactivesw.catalog.product.infrastructure.validator.AttributeConstraintValidator;
import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.model.QueryConditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
   * RestTemplate.
   */
  @Autowired
  @Qualifier("restTemplate")
  private transient RestTemplate restTemplate;

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

    ProductType productType = getProductType(productTypeId);

    AttributeConstraintValidator.validate(productType.getAttributes(), productDraft);

    Product result = productService.createProduct(productDraft);

    LOG.debug("end createProduct, new product is : {}", result.toString());

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

    String categoryId = getCategoryId(queryConditions);

    List<ProductEntity> productEntities = productService.queryProductByCategory(categoryId);
    
    List<ProductProjection> result = ProductProjectionMapper.entityToModel(productEntities);

    LOG.debug("end queryProductProjections, product projections number is : {}", result.size());

    return result;
  }

  /**
   * Gets category id.
   *
   * @param queryConditions the query conditions
   * @return the category id
   */
  private String getCategoryId(QueryConditions queryConditions) {
    String where = queryConditions.getWhere();
    String[] conditions = where.split(":");
    return conditions[conditions.length - 1].replaceAll("\"","");
  }

  /**
   * Gets product type.
   *
   * @param id the id
   * @return the product type
   */
  private ProductType getProductType(String id) {
    String url = "http://localhost:8088/product-types/" + id;
    ProductType result = restTemplate.getForObject(url, ProductType.class);

    if (result == null) {
      LOG.debug("can not find product type by id : {}", id);
      throw new NotExistException("ProductType Not Found");
    }
    return result;
  }
}