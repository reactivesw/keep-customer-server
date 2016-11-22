package io.reactivesw.orders.carts.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.catalog.products.models.attributes.Attribute;
import io.swagger.annotations.ApiOperation;

/**
 * Created by umasuo on 16/11/22.
 */
@RestController
public class TestController {

  @ApiOperation("")
  @PostMapping("/test")
  public Attribute testApi(@RequestBody Attribute attr) {
    return attr;
  }
  @ApiOperation("")
  @PostMapping("/test1")
  public LocalizedString testApi1(@RequestBody LocalizedString attr) {
    return attr;
  }
}
