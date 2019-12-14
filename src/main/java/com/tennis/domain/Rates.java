package com.tennis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Rates {
    private BigDecimal eur;
    private BigDecimal usd;
}
