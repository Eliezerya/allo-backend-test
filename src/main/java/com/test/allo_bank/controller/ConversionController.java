package com.test.allo_bank.controller;


import com.test.allo_bank.component.InMemoryDataStore;
import com.test.allo_bank.dto.IDRDataFetcher;
import com.test.allo_bank.dto.UnifiedResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/finance/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConversionController {

    private final Map<String, IDRDataFetcher> fetcherStrategies;
    private final InMemoryDataStore dataStore;

    public ConversionController(Map<String, IDRDataFetcher> strategyMap, InMemoryDataStore dataStore) {
        this.fetcherStrategies = strategyMap;
        this.dataStore = dataStore;
    }


    @GetMapping(value = "/{resourceType}")
    public Object getConversion(@PathVariable (value = "resourceType") String resourceType){
        IDRDataFetcher strategy = fetcherStrategies.get(resourceType);
        if (strategy == null){
            throw new IllegalArgumentException("Unknown resourceType: " + resourceType);
        }
        Object response = dataStore.get(resourceType);
        return response;
    }
}
