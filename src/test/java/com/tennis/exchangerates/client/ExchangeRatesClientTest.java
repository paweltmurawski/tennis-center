package com.tennis.exchangerates.client;

import com.tennis.dto.ExchangeRatesDto;
import com.tennis.dto.Rates;
import com.tennis.exchangerates.config.ExchangeRatesConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ExchangeRatesClientTest {
    @InjectMocks
    private ExchangeRatesClient exchangeRatesClient;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ExchangeRatesConfig exchangeRatesConfig;

    @Test
    public void testShouldFetchExchangeRatesBoard() throws URISyntaxException {
        //Given
        when(exchangeRatesConfig.getExchangeRateApiEndpoint()).thenReturn("http://test.com/");

        ExchangeRatesDto[] exchangeRates = new ExchangeRatesDto[1];
        exchangeRates[0] = new ExchangeRatesDto("test base", "test date", new Rates(new BigDecimal(3.652), new BigDecimal(4.034)));

        URI uri = new URI("http://test.com/latest?base=PLN");

        when(restTemplate.getForObject(uri, ExchangeRatesDto[].class)).thenReturn(exchangeRates);

        //When
        List<ExchangeRatesDto> fetchedExchangeRates = exchangeRatesClient.getExchangeRates();

        //Then
        assertEquals(1, fetchedExchangeRates.size());
        assertEquals("test base", fetchedExchangeRates.get(0).getBase());
        assertEquals("test date", fetchedExchangeRates.get(0).getDate());
        assertEquals(3.652, fetchedExchangeRates.get(0).getRate().getEur());
        assertEquals(4.034, fetchedExchangeRates.get(0).getRate().getUsd());
    }

}