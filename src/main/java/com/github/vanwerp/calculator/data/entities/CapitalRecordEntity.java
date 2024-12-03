package com.github.vanwerp.calculator.data.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "capital_record")
public class CapitalRecordEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "initial_capital")
    private BigDecimal initialCapital;

    @Column(name = "final_capital")
    private BigDecimal finalCapital;

    @Column(name = "years")
    private Integer years;

    @Column(name = "compounding_period")
    private Integer compoundingPeriod;

    @Column(name = "revenue")
    private BigDecimal revenue;
}
