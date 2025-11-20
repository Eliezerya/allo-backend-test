package com.test.allo_bank.service;


import com.test.allo_bank.dto.CurrenciesDTO;
import com.test.allo_bank.dto.IDRDataFetcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component("supported_currencies")
public class SupportedCurrenciesFetcher implements IDRDataFetcher {

    @Value("${frankfurter.api.base-url}")
    private String baseUrl;
    private final WebClient client;

    public SupportedCurrenciesFetcher(WebClient client) {
        this.client = client;
    }

    @Override
    public String resourceType() {
        return "supported_currencies";
    }

    @Override
    public Object fetchData() {

        Map currencies = client.get()
                .uri("/currencies")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return new CurrenciesDTO(currencies);
    }
}