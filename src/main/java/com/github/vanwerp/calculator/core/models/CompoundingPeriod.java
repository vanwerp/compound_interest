package com.github.vanwerp.calculator.core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum CompoundingPeriod {

    DAILY(365),
    MONTHLY(12),
    ANNUALLY(1);

    private Integer period;


}
