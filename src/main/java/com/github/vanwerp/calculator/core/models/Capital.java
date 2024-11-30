package com.github.vanwerp.calculator.core.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class Capital {

    private BigDecimal initialCapital;

    private BigDecimal finalCapital;

    private BigDecimal interest;

    private List<YearCapital> yearCapitalList;
}
