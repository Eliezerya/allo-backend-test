package com.test.allo_bank.dto;

import java.util.Map;

public record CurrenciesDTO(
        Map<String, String> currencies
) {
}
