package com.github.vanwerp.calculator.core.services;

import com.github.vanwerp.calculator.core.models.*;
import com.github.vanwerp.calculator.data.repositories.CalculationRecordRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CompoundInterestServiceImpl implements CompoundInterestService{

    @Inject
    CalculationRecordRepository calculationRecordRepository;

    @Override
    public List<CapitalRecord> getCapitalRecord(Integer page, Integer entries){
        return calculationRecordRepository.getCapitalRecord(page, entries);
    }

    @Override
    public Capital getCompoundInterest(CapitalCalculationVariables capitalCalculationVariables){

        List<YearCapital> yearCapitalResources = new ArrayList<>();
        BigDecimal finalCapital = capitalCalculationVariables.getInitialCapital();

        for (int i = 1; i <= capitalCalculationVariables.getTime() ; i++) {
            BigDecimal finalPeriodCapital = computeCompoundInterest(i, capitalCalculationVariables.getCompoundingPeriod(), capitalCalculationVariables.getInitialCapital(), capitalCalculationVariables.getRevenue());
            BigDecimal periodInterest = finalPeriodCapital.subtract(capitalCalculationVariables.getInitialCapital());
            yearCapitalResources.add(new YearCapital(i,periodInterest,finalPeriodCapital));
            finalCapital = finalPeriodCapital;
        }

        calculationRecordRepository.saveCalculationRecord(
                new CapitalRecord(
                        capitalCalculationVariables.getInitialCapital(),
                        finalCapital,
                        capitalCalculationVariables.getCompoundingPeriod().getPeriod(),
                        capitalCalculationVariables.getTime(),
                        capitalCalculationVariables.getRevenue()));

        return Capital.builder()
                .finalCapital(finalCapital)
                .interest(finalCapital.subtract(capitalCalculationVariables.getInitialCapital()))
                .initialCapital(capitalCalculationVariables.getInitialCapital())
                .yearCapitalList(yearCapitalResources)
                .build();
    }

    private BigDecimal computeCompoundInterest(Integer years, CompoundingPeriod compoundingPeriod,
                                               BigDecimal initialCapital, BigDecimal annualInterestRatePercentage){

        BigDecimal annualInterestRateDecimal = annualInterestRatePercentage
                .divide(new BigDecimal("100"), 5, RoundingMode.HALF_UP);

        int totalCompoundingPeriod = compoundingPeriod.getPeriod() * years;

        BigDecimal rateByUnitPeriod = annualInterestRateDecimal
                .divide(new BigDecimal(compoundingPeriod.getPeriod().toString()), 5,RoundingMode.HALF_UP);

        return initialCapital.multiply(BigDecimal.ONE.add(rateByUnitPeriod).pow(totalCompoundingPeriod)).setScale(2,RoundingMode.HALF_UP);
    }

}
