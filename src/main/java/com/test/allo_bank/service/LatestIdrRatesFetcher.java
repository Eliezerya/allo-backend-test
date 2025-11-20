package com.test.allo_bank.service;

import com.test.allo_bank.dto.IDRDataFetcher;
import com.test.allo_bank.dto.LatestRatesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component("latest_idr_rates")
public class LatestIdrRatesFetcher implements IDRDataFetcher {
    @Value("${frankfurter.api.base-url}")
    private String baseUrl;
    @Autowired
    private final WebClient client;

    @Value("${github.username}")
    private String githubUsername;

    public LatestIdrRatesFetcher(WebClient client) {
        this.client = client;
    }

    @Override
    public String resourceType() {
        return "latest_idr_rates";
    }

    @Override
    public Object fetchData() {

        Map response = client.get()
                .uri(baseUrl+"/latest?base=IDR")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        double amount = (double) response.get("amount");
        String base = (String) response.get("base");
        String date = (String) response.get("date");

        Map<String, Double> rates = (Map<String, Double>) response.get("rates");

        double rateUsd = rates.get("USD");

        // Calculate Spread Factor
        int unicodeSum = githubUsername.toLowerCase().chars().sum();
        double spreadFactor = (unicodeSum % 1000) / 100000.0;

        double usdBuySpreadIdr = (1 / rateUsd) * (1 + spreadFactor);

        return new LatestRatesDTO(amount, base, date, rates, usdBuySpreadIdr);
    }
}
