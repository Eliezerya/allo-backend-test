package com.test.allo_bank.dto;


import lombok.AllArgsConstructor;

public interface IDRDataFetcher {
    Object fetchData();
    String resourceType();
}
