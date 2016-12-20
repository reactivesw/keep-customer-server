package io.reactivesw.catalog.product.domain.service;

import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.mapper.ProductMapper;
import io.reactivesw.catalog.product.domain.entity.ProductEntity;
import io.reactivesw.catalog.product.infrastructure.repository.ProductRepository;
import io.reactivesw.common.exception.NotExistException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/14.
 */
@Service
public class ProductService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

  /**
   * ProductRepository.
   */
  @Autowired
  private transient ProductRepository productRepository;

  /**
   * Create product.
   *
   * @param productDraft the product draft
   * @return the product
   */
  public Product createProduct(ProductDraft productDraft) {
    LOG.debug("enter createProduct, ProductDraft is : {}", productDraft.toString());

    ProductEntity entity = ProductMapper.modelToEntity(productDraft);

    ProductEntity savedEntity = productRepository.save(entity);

    Product result = ProductMapper.entityToModel(savedEntity);

    LOG.debug("end createProduct, created Product is : {}", result.toString());

    return result;
  }

  /**
   * Gets product by id.
   *
   * @param id the id
   * @return the product by id
   */
  public Product getProductById(String id) {
    LOG.debug("enter getProductById, id is : {}", id);

    ProductEntity entity = getProductEntityById(id);

    Product result = ProductMapper.entityToModel(entity);

    LOG.debug("end getProductById, get Product is : {}", result.toString());

    return result;
  }


  /**
   * Gets product entity by id.
   *
   * @param id the id
   * @return the product entity by id
   */
  private ProductEntity getProductEntityById(String id) {
    ProductEntity entity = productRepository.findOne(id);
    if (entity == null) {
      LOG.debug("can not find product by id : {}", id);
      throw new NotExistException("Product Not Found");
    }
    return entity;
  }
}
