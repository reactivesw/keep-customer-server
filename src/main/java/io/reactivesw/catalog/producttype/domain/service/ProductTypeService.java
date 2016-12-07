package io.reactivesw.catalog.producttype.domain.service;

import io.reactivesw.catalog.producttype.application.model.ProductType;
import io.reactivesw.catalog.producttype.application.model.ProductTypeDraft;
import io.reactivesw.catalog.producttype.application.model.mapper.ProductTypeMapper;
import io.reactivesw.catalog.producttype.domain.entity.ProductTypeEntity;
import io.reactivesw.catalog.producttype.infrastructure.repository.ProductTypeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Davis on 16/12/7.
 */
@Service
public class ProductTypeService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ProductTypeService.class);

  /**
   * The Product type repository.
   */
  @Autowired
  private transient ProductTypeRepository productTypeRepository;

  /**
   * Create product type.
   *
   * @param productTypeDraft the product type draft
   * @return the product type
   */
  public ProductType createProductType(ProductTypeDraft productTypeDraft) {
    LOG.debug("enter createProductType, product type draft is:{}", productTypeDraft.toString());

    ProductTypeEntity entity = ProductTypeMapper.modelToEntity(productTypeDraft);

    ProductTypeEntity savedEntity = productTypeRepository.save(entity);

    ProductType result = ProductTypeMapper.entityToModel(savedEntity);

    LOG.debug("end createProductType, new product type is:{}", result.toString());
    return result;
  }
}
