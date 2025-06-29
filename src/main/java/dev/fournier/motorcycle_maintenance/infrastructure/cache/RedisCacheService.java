package dev.fournier.motorcycle_maintenance.infrastructure.cache;

import dev.fournier.motorcycle_maintenance.application.service.CacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

import java.time.Duration;

@Service
public class RedisCacheService implements CacheService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final long DEFAULT_TTL_MINUTES = 10;

    public RedisCacheService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getOrLoad(String key, Supplier<T> loader) {
        T cached = (T) redisTemplate.opsForValue().get(key);
        if (cached != null) {
            return cached;
        }

        T loaded = loader.get();
        if (loaded != null) {
            redisTemplate.opsForValue().set(key, loaded, Duration.ofMinutes(DEFAULT_TTL_MINUTES));
        }
        return loaded;
    }

    @Override
    public void evict(String key) {
        redisTemplate.delete(key);
    }
}
