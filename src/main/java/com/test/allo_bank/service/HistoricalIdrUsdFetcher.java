package com.test.allo_bank.service;


import com.test.allo_bank.dto.HistoricalRatesDTO;
import com.test.allo_bank.dto.IDRDataFetcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component("historical_idr_usd")
public class HistoricalIdrUsdFetcher implements IDRDataFetcher {

    @Value("${frankfurter.api.base-url}")
    private String baseUrl;
    private final WebClient client;

    public HistoricalIdrUsdFetcher(WebClient client) {
        this.client = client;
    }

    @Override
    public String resourceType() {
        return "historical_idr_usd";
    }

    @Override
    public Object fetchData() {

        Map response = client.get()
                .uri("/2024-01-01..2024-01-05?from=IDR&to=USD")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        double amount = (double) response.get("amount");
        String base = (String) response.get("base");
        String start = (String) response.get("start_date");
        String end = (String) response.get("end_date");

        Map<String, Map<String, Double>> rates =
                (Map<String, Map<String, Double>>) response.get("rates");

        return new HistoricalRatesDTO(amount, base, start, end, rates);
    }
}