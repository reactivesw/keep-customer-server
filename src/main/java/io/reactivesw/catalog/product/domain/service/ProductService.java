package io.reactivesw.catalog.product.domain.service;

import io.reactivesw.catalog.product.application.model.Product;
import io.reactivesw.catalog.product.application.model.ProductDraft;
import io.reactivesw.catalog.product.application.model.mapper.ProductMapper;
import io.reactivesw.catalog.product.domain.entity.ProductEntity;
import io.reactivesw.catalog.product.infrastructure.repository.ProductRepository;
import io.reactivesw.catalog.product.infrastructure.validator.SkuNameValidator;
import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
  @Transactional
  public Product createProduct(ProductDraft productDraft) {
    LOG.debug("enter createProduct, ProductDraft is : {}", productDraft.toString());

    List<ProductEntity> products = productRepository.findAll();
    validateSlug(productDraft.getSlug(), products);
    SkuNameValidator.validate(productDraft, products);

    ProductEntity entity = ProductMapper.modelToEntity(productDraft);

    ProductEntity savedEntity = productRepository.save(entity);

    Product result = ProductMapper.entityToModel(savedEntity);

    LOG.debug("end createProduct, created Product is : {}", result.toString());

    return result;
  }

  /**
   * Query product by category list.
   *
   * @param categoryId the category id
   * @return the list
   */
  public List<ProductEntity> queryProductByCategory(String categoryId) {
    LOG.debug("enter queryProductByCategory, categoryId is : {}", categoryId);

    List<ProductEntity> productEntities = productRepository.findAll();

    List<ProductEntity> result = productEntities.stream().filter(
        productEntity ->
            productEntity.getMasterData().getCurrent().getCategories().contains(categoryId)
    ).collect(Collectors.toList());

    LOG.debug("end queryProductByCategory, get product number is : {}", result.size());
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

  /**
   * validate slug.
   *
   * @param slug     the slug.
   * @param products the products.
   */
  private void validateSlug(String slug, List<ProductEntity> products) {
    if (products != null) {
      products.parallelStream().forEach(
          product -> {
            validateSlug(slug, product);
          }
      );
    }
  }

  /**
   * validate slug.
   *
   * @param slug    the slug
   * @param product the product
   */
  private void validateSlug(String slug, ProductEntity product) {
    if (StringUtils.equals(slug, product.getMasterData().getCurrent().getSlug())
        || StringUtils.equals(slug, product.getMasterData().getStaged().getSlug())) {
      LOG.debug("slug : {} has already exists", slug);
      throw new ConflictException("slug has already exists");
    }
  }
}
