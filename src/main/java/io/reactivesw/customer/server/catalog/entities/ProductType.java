package io.reactivesw.customer.server.catalog.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Davis on 16/11/16.
 */
@Entity
@Table(name = "sw_product_type")
public class ProductType {
  String id;
  int version;
  String key;
  String name;
  String description;
  Set<AttributeDefinition> attributes;
}
