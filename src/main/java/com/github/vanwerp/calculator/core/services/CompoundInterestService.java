package com.github.vanwerp.calculator.core.services;


import com.github.vanwerp.calculator.core.models.CapitalCalculationVariables;
import com.github.vanwerp.calculator.core.models.Capital;
import com.github.vanwerp.calculator.core.models.CapitalRecord;

import java.util.List;

public interface CompoundInterestService {
    List<CapitalRecord> getCapitalRecord(Integer page, Integer entries);

    Capital getCompoundInterest(CapitalCalculationVariables capitalCalculationVariables);
}
