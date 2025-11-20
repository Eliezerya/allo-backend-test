package com.test.allo_bank.component;

import com.test.allo_bank.dto.IDRDataFetcher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StartupDataLoader implements ApplicationRunner {

    private final Map<String, IDRDataFetcher> fetchers;
    private final InMemoryDataStore store;

    public StartupDataLoader(Map<String, IDRDataFetcher> fetchers, InMemoryDataStore store) {
        this.fetchers = fetchers;
        this.store = store;
    }

    @Override
    public void run(ApplicationArguments args) {
        fetchers.forEach((key, strategy) -> {
            Object result = strategy.fetchData();
            store.put(key, result);
        });
    }
}
