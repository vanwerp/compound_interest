package com.github.vanwerp.calculator.api.request;

import com.github.vanwerp.calculator.core.models.CompoundingPeriod;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapitalCalculationRequest {

    @NotNull(message = "Time can not be null")
    private Integer time;

    @NotNull(message = "Compounding period can not be null")
    private CompoundingPeriod compoundingPeriod;

    @NotNull(message = "Initial Capital can not be null")
    private BigDecimal initialCapital;

    @NotNull(message = "Revenue can not be null")
    private BigDecimal revenue;
}
