package com.github.vanwerp.calculator.api.controller;


import com.github.vanwerp.calculator.api.mapper.CapitalMapper;
import com.github.vanwerp.calculator.api.request.CapitalCalculationRequest;
import com.github.vanwerp.calculator.api.resources.CapitalRecordResource;
import com.github.vanwerp.calculator.api.resources.CapitalResource;
import com.github.vanwerp.calculator.core.services.CompoundInterestService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Slf4j
@Path("/capital")
public class CapitalController {

    @Inject
    private CompoundInterestService compoundInterestService;

    @Inject
    private CapitalMapper capitalMapper;

    @POST
    public RestResponse<CapitalResource> computeCompoundInterest(@Valid CapitalCalculationRequest capitalRequest) {
        return RestResponse.ok(
                capitalMapper.toResource(compoundInterestService.getCompoundInterest(capitalMapper.toModel(capitalRequest))));
    }

    @GET
    public RestResponse<List<CapitalRecordResource>> getCapitalRecord(@RestQuery Integer page,
                                                                      @RestQuery Integer entries){
        return RestResponse.ok(capitalMapper.toRecordResource(compoundInterestService.getCapitalRecord(page, entries)));
    }

}
