package com.github.vanwerp.calculator.core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Period;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeriodCapital {

    private Period period;

    private Double periodInterest;

    private BigDecimal initialPeriodCapital;

    private Double finalPeriodCapital;

}
