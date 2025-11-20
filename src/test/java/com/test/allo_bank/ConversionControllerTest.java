package com.test.allo_bank;

import com.test.allo_bank.component.InMemoryDataStore;
import com.test.allo_bank.controller.ConversionController;
import com.test.allo_bank.dto.CurrenciesDTO;
import com.test.allo_bank.dto.IDRDataFetcher;
import com.test.allo_bank.dto.UnifiedResponseDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.ObjectError;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ConversionControllerTest {
    @Mock
    private InMemoryDataStore dataStore;

    @Mock
    private Map<String, IDRDataFetcher> fetcherStrategies;

    @InjectMocks
    private ConversionController controller;

    @Test
    void testGetConversion_supportedCurrencies() {
        IDRDataFetcher dummyStrategy = mock(IDRDataFetcher.class);

        fetcherStrategies = Map.of("supported_currencies", dummyStrategy);

        controller = new ConversionController(fetcherStrategies, dataStore);

        Map<String, String> currenciesMap = Map.of(
                "IDR", "Indonesian Rupiah",
                "USD", "United States Dollar"
        );
        CurrenciesDTO currenciesDTO = new CurrenciesDTO(currenciesMap);
        when(dataStore.get("supported_currencies")).thenReturn(currenciesDTO);

        Object response = controller.getConversion("supported_currencies");

        assertEquals(currenciesDTO, response);
    }


    @Test
    void testGetConversion_invalidResourceType() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                controller.getConversion("invalid_type")
        );

        assertTrue(exception.getMessage().contains("Unknown resourceType"));
    }
}
