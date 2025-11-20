package com.test.allo_bank.dto;

public record UnifiedResponseDTO<T>(
        String resourceType,
        T data
) {
}
