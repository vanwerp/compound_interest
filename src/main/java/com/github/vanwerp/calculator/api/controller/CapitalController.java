package com.github.vanwerp.calculator.api.controller;


import com.github.vanwerp.calculator.api.mapper.CapitalMapper;
import com.github.vanwerp.calculator.api.resources.CapitalResource;
import com.github.vanwerp.calculator.core.models.CompoundingPeriod;
import com.github.vanwerp.calculator.core.services.CompoundInterestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;

import java.math.BigDecimal;

@Slf4j
@Path("/capital")
public class CapitalController {

    @Inject
    private CompoundInterestService compoundInterestService;

    @Inject
    private CapitalMapper capitalMapper;

    @GET
    public RestResponse<CapitalResource> computeCompoundInterest(@RestQuery Integer time,
                                                                 @RestQuery CompoundingPeriod compoundingPeriod,
                                                                 @RestQuery BigDecimal initialCapital,
                                                                 @RestQuery BigDecimal revenue){
        return RestResponse.ok(
                capitalMapper.toResource(compoundInterestService.getCompoundInterest(time,initialCapital,revenue, compoundingPeriod)));
    }

}
