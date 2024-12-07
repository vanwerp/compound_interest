package com.github.vanwerp.calculator.core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapitalCalculationVariables {

    private Integer time;

    private CompoundingPeriod compoundingPeriod;

    private BigDecimal initialCapital;

    private BigDecimal revenue;
}
