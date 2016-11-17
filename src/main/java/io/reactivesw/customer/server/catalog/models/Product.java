package io.reactivesw.customer.server.catalog.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by Davis on 16/11/17.
 */
public class Product {
  /**
   * The Id.
   */
  private String id;
  /**
   * The Create at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createAt;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets create at.
   *
   * @return the create at
   */
  public ZonedDateTime getCreateAt() {
    return createAt;
  }

  /**
   * Sets create at.
   *
   * @param createAt the create at
   */
  public void setCreateAt(ZonedDateTime createAt) {
    this.createAt = createAt;
  }

  public Product() {
    this.id = UUID.randomUUID().toString();
    this.createAt = ZonedDateTime.now();
  }
}
