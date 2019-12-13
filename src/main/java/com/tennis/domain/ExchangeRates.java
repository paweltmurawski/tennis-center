package com.tennis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExchangeRates {
    private String base;
    private String date;
    private String rate;
}
