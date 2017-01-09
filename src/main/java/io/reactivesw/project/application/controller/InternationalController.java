package io.reactivesw.project.application.controller;

import io.reactivesw.common.model.UpdateRequest;
import io.reactivesw.project.application.model.International;
import io.reactivesw.project.application.model.action.InternationalUpdateAction;
import io.reactivesw.project.domain.service.InternationalService;
import io.reactivesw.route.ProjectRouter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by umasuo on 17/1/5.
 */
@RestController
public class InternationalController {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(InternationalController.class);

  /**
   * service
   */
  @Autowired
  private transient InternationalService service;

  /**
   * Gets international.
   *
   * @return the international
   */
  @ApiOperation(value = "get international of this project")
  @GetMapping(value = ProjectRouter.INTERNATIONAL_ROOT)
  public International getInternational() {
    LOG.debug("enter getInternational");

    International international = service.getInternational();

    LOG.debug("end getInternational, reuslt is : {}", international.toString());

    return international;
  }

  /**
   * Update international international.
   *
   * @return the international
   */
  @ApiOperation(value = "update international")
  @PutMapping(value = ProjectRouter.INTERNATIONAL_ROOT)
  public International updateInternational(@RequestBody
                                           @ApiParam(value = "International Update Fields",
                                               required = true)
                                           @Valid
                                               UpdateRequest<InternationalUpdateAction>
                                                 updateRequest) {
    LOG.debug("enter updateInternational");

    International result = service.updateInternational(updateRequest.getActions());

    LOG.debug("end updateInternational, updated international is : {}", result.toString());

    return result;
  }
}
