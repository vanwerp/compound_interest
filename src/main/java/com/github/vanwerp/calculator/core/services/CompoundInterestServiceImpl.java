package com.github.vanwerp.calculator.core.services;

import com.github.vanwerp.calculator.core.models.Capital;
import com.github.vanwerp.calculator.core.models.CapitalRecord;
import com.github.vanwerp.calculator.core.models.CompoundingPeriod;
import com.github.vanwerp.calculator.core.models.YearCapital;
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
    public Capital getCompoundInterest(Integer years, BigDecimal initialCapital, BigDecimal revenue,
                                       CompoundingPeriod compoundingPeriod){

        List<YearCapital> yearCapitalResources = new ArrayList<>();
        BigDecimal finalCapital = initialCapital;

        for (int i = 1; i <= years ; i++) {
            BigDecimal finalPeriodCapital = computeCompoundInterest(i, compoundingPeriod,initialCapital,revenue);
            BigDecimal periodInterest = finalPeriodCapital.subtract(initialCapital);
            yearCapitalResources.add(new YearCapital(i,periodInterest,finalPeriodCapital));
            finalCapital = finalPeriodCapital;
        }

        calculationRecordRepository.saveCalculationRecord(
                new CapitalRecord(
                        initialCapital,
                        finalCapital,
                        compoundingPeriod.getPeriod(),
                        years,
                        revenue));

        return Capital.builder()
                .finalCapital(finalCapital)
                .interest(finalCapital.subtract(initialCapital))
                .initialCapital(initialCapital)
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
