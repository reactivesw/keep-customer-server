package io.reactivesw.common.entities;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Created by Davis on 16/11/22.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseAllEntity  extends BaseIdEntity{

  @Column(name = "created_at")
  protected ZonedDateTime createdAt;

  @Column(name = "last_modified_at")
  protected ZonedDateTime lastModifiedAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }
}
