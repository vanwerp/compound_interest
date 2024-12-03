package com.github.vanwerp.calculator.data;

import com.github.vanwerp.calculator.core.models.CapitalRecord;
import com.github.vanwerp.calculator.data.entities.CapitalRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CapitalEntityMapper {

    CapitalRecordEntity toEntity (CapitalRecord record);
    CapitalRecord toRecord (CapitalRecordEntity entity);

}
