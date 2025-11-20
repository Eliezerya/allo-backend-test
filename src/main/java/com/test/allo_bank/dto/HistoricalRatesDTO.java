package com.test.allo_bank.dto;

import java.util.Map;

public record HistoricalRatesDTO(
        double amount,
        String base,
        String startDate,
        String endDate,
        Map<String, Map<String, Double>> rates
) {
}
