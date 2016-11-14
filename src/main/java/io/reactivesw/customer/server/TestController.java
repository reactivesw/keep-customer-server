package io.reactivesw.customer.server;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created by bruceliu on 16/11/14.
 */
@RestController
public class TestController {


  @ApiOperation(value = "Get test's message")
  @GetMapping("/test")
  public String testApi(@RequestParam("userId") @ApiParam(value = "User ID", required = true) @NotNull String userId){
    return "this is the test message, user id is: " + userId;
  }
}
