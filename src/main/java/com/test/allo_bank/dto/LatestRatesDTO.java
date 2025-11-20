package com.test.allo_bank.dto;

import java.util.Map;

public record LatestRatesDTO(
        double amount,
        String base,
        String date,
        Map<String, Double> rates,
        double usdBuySpreadIdr
) {
}
