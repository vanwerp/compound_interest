package com.github.vanwerp.calculator.core.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YearCapital {

    private Integer year;

    private BigDecimal periodInterest;

    private BigDecimal finalPeriodCapital;
}
