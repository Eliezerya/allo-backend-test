package com.test.allo_bank.component;


import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryDataStore {
    private final Map<String, Object> storage = new ConcurrentHashMap<>();

    public void put(String key, Object value) {
        storage.put(key, value);
    }

    public Object get(String key) {
        return storage.get(key);
    }
}
