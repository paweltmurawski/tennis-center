package com.tennis.controller;

import com.tennis.dto.ExchangeRatesDto;
import com.tennis.exchangerates.client.ExchangeRatesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class ExchangeRatesController {
    @Autowired
    private ExchangeRatesClient exchangeRatesClient;

    @RequestMapping(method = RequestMethod.GET, value = "/exchangerates")
    public List<ExchangeRatesDto> getExchangeRates() {
        return exchangeRatesClient.getExchangeRates();
    }
}
