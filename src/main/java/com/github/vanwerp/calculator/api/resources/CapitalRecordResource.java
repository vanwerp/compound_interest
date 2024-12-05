package com.github.vanwerp.calculator.api.resources;

import java.math.BigDecimal;

public record CapitalRecordResource(Long id,
                                    BigDecimal initialCapital,
                                    BigDecimal finalCapital,
                                    Integer years,
                                    Integer compoundingPeriod,
                                    BigDecimal revenue) {
}
