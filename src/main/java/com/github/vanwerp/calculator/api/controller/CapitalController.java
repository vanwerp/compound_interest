package com.github.vanwerp.calculator.api.controller;


import com.github.vanwerp.calculator.api.mapper.CapitalMapper;
import com.github.vanwerp.calculator.api.resources.CapitalResource;
import com.github.vanwerp.calculator.api.resources.CapitalRecordResource;
import com.github.vanwerp.calculator.core.models.CompoundingPeriod;
import com.github.vanwerp.calculator.core.services.CompoundInterestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Path("/capital")
public class CapitalController {

    @Inject
    private CompoundInterestService compoundInterestService;

    @Inject
    private CapitalMapper capitalMapper;

    @POST
    public RestResponse<CapitalResource> computeCompoundInterest(@RestQuery Integer time,
                                                                 @RestQuery CompoundingPeriod compoundingPeriod,
                                                                 @RestQuery BigDecimal initialCapital,
                                                                 @RestQuery BigDecimal revenue){
        return RestResponse.ok(
                capitalMapper.toResource(compoundInterestService.getCompoundInterest(time,initialCapital,revenue, compoundingPeriod)));
    }

    @GET
    public RestResponse<List<CapitalRecordResource>> getAllCapitalRecord(){
        return RestResponse.ok(capitalMapper.toRecordResource(compoundInterestService.getAllCapitalRecord()));
    }

}
