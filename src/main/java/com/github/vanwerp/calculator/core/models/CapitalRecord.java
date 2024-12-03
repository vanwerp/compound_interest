package com.github.vanwerp.calculator.core.models;

import java.math.BigDecimal;

public record CapitalRecord(Long id,
                            BigDecimal initialCapital,
                            BigDecimal finalCapital,
                            Integer years,
                            Integer compoundingPeriod,
                            BigDecimal revenue) {

    public CapitalRecord(BigDecimal initialCapital, BigDecimal finalCapital, Integer years, Integer compoundingPeriod, BigDecimal revenue) {
        this(null, initialCapital, finalCapital, years, compoundingPeriod, revenue);
    }
}
