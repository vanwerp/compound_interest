package com.github.vanwerp.calculator.api.resources;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class CapitalResource {

    private BigDecimal initialCapital;

    private BigDecimal finalCapital;

    private BigDecimal interest;

    private List<YearCapitalResource> yearCapitalResourceList;

}
