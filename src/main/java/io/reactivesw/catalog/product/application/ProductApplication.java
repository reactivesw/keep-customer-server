package io.reactivesw.catalog.product.application;

import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.domain.service.ProductService;
import io.reactivesw.catalog.product.infrastructure.validator.AttributeConstraintValidator;
import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.common.exception.NotExistException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    AttributeConstraintValidator.validateAttribute(productType.getAttributes(), productDraft);

    Product result = productService.createProduct(productDraft);

    LOG.debug("end createProduct, new product is : {}", result.toString());

    return result;
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