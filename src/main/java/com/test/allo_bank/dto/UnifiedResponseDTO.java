package com.test.allo_bank.dto;

public record UnifiedResponseDTO(
        String resourceType,
        Object data
) {
}
