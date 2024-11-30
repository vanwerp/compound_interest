package com.github.vanwerp.calculator.api.mapper;

import com.github.vanwerp.calculator.api.resources.CapitalResource;
import com.github.vanwerp.calculator.api.resources.YearCapitalResource;
import com.github.vanwerp.calculator.core.models.Capital;
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

}
