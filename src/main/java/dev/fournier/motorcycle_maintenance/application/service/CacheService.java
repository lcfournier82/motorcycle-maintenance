package dev.fournier.motorcycle_maintenance.application.service;

import java.util.function.Supplier;

public interface CacheService {
    <T> T getOrLoad(String key, Supplier<T> loader);
    void evict(String key);
}