package io.reactivesw.customer.server.cart;

import io.reactivesw.customer.server.common.types.Reference;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
public class SyncInfo {

  /**
   * Reference to a Channel.
   * Connection to particular synchronization destination.
   */
  private Reference channel;

  /**
   * Can be used to reference an external order instance, file etc.
   */
  private String externalId;


  /**
   * The Synced at.
   */
  private ZonedDateTime syncedAt;

}
