package com.github.vanwerp.calculator.data.mappers;

import com.github.vanwerp.calculator.core.models.CapitalRecord;
import com.github.vanwerp.calculator.data.entities.CapitalRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CapitalEntityMapper {

    CapitalRecordEntity toEntity (CapitalRecord record);
    CapitalRecord toRecord (CapitalRecordEntity entity);
    List<CapitalRecord> toRecordList (List<CapitalRecordEntity> entity);

}
