package com.github.vanwerp.calculator.api.mapper;

import com.github.vanwerp.calculator.api.request.CapitalCalculationRequest;
import com.github.vanwerp.calculator.api.resources.CapitalRecordResource;
import com.github.vanwerp.calculator.api.resources.CapitalResource;
import com.github.vanwerp.calculator.api.resources.YearCapitalResource;
import com.github.vanwerp.calculator.core.models.CapitalCalculationVariables;
import com.github.vanwerp.calculator.core.models.Capital;
import com.github.vanwerp.calculator.core.models.CapitalRecord;
import com.github.vanwerp.calculator.core.models.YearCapital;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CapitalMapper {

    @Mapping(target = "yearCapitalResourceList", source = "yearCapitalList")
    CapitalResource toResource(Capital capital);

    List<YearCapitalResource> toResource(List<YearCapital> yearCapitalList);

    YearCapitalResource toResource(YearCapital yearCapital);

    List<CapitalRecordResource> toRecordResource(List<CapitalRecord> records);

    CapitalCalculationVariables toModel (CapitalCalculationRequest request);

}
