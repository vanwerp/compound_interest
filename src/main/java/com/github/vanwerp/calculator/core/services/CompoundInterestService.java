package com.github.vanwerp.calculator.core.services;


import com.github.vanwerp.calculator.core.models.Capital;
import com.github.vanwerp.calculator.core.models.CompoundingPeriod;

import java.math.BigDecimal;

public interface CompoundInterestService {
    Capital getCompoundInterest(Integer time,
                                BigDecimal initialCapital,
                                BigDecimal revenue, CompoundingPeriod compoundingPeriod);
}
