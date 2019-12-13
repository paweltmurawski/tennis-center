package com.tennis.exchangerates.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ExchangeRatesConfig {
    @Value("${exchangerates.api.endpoint}")
    private String exchangeRateApiEndpoint;
}
