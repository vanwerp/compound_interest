package com.github.vanwerp.calculator.api.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YearCapitalResource {

    private Integer year;

    private BigDecimal periodInterest;

    private BigDecimal finalPeriodCapital;

}
