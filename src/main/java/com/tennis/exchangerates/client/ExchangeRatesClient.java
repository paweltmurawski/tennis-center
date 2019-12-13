package com.tennis.exchangerates.client;

import com.tennis.dto.ExchangeRatesDto;
import com.tennis.exchangerates.config.ExchangeRatesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class ExchangeRatesClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRatesClient.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ExchangeRatesConfig exchangeRatesConfig;

    private URI urlBuilder() {
        URI url = UriComponentsBuilder.fromHttpUrl(exchangeRatesConfig.getExchangeRateApiEndpoint() + "latest")
                .queryParam("base", "PLN")
                .build().encode().toUri();
        return url;
    }

    public List<ExchangeRatesDto> getExchangeRates() {
        try {
            ExchangeRatesDto[] exchangeResponse = restTemplate.getForObject(urlBuilder(), ExchangeRatesDto[].class);
            return Arrays.asList(ofNullable(exchangeResponse).orElse(new ExchangeRatesDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
   }
}
