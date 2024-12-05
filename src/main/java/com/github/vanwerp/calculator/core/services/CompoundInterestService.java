package com.github.vanwerp.calculator.core.services;


import com.github.vanwerp.calculator.core.models.Capital;
import com.github.vanwerp.calculator.core.models.CapitalRecord;
import com.github.vanwerp.calculator.core.models.CompoundingPeriod;

import java.math.BigDecimal;
import java.util.List;

public interface CompoundInterestService {
    List<CapitalRecord> getAllCapitalRecord();

    Capital getCompoundInterest(Integer time,
                                BigDecimal initialCapital,
                                BigDecimal revenue, CompoundingPeriod compoundingPeriod);
}
