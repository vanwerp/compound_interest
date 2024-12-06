package com.github.vanwerp.calculator.data.repositories;

import com.github.vanwerp.calculator.core.models.CapitalRecord;
import com.github.vanwerp.calculator.data.CapitalEntityMapper;
import com.github.vanwerp.calculator.data.entities.CapitalRecordEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped
public class CalculationRecordRepository implements PanacheRepository<CapitalRecordEntity> {

    @Inject
    private CapitalEntityMapper mapper;

    @Transactional
    public CapitalRecord saveCalculationRecord(CapitalRecord capitalRecord){
        CapitalRecordEntity entity = mapper.toEntity(capitalRecord);
        persist(entity);
        return mapper.toRecord(entity);
    }

    @Transactional
    public List<CapitalRecord> getCapitalRecord(Integer page, Integer entries){
        return mapper.toRecordList(findAll().page(page,entries).list());
    }

}
