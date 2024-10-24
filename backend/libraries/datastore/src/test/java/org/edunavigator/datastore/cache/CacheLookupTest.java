package org.edunavigator.datastore.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CacheLookupTest {
    private CacheConfig cacheConfig;
    private CacheLookup cacheLookup;
    private JedisPool jedisPool;
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        jedisPool = mock(JedisPool.class);
        jedis = mock(Jedis.class);
        cacheConfig = mock(CacheConfig.class);
        when(cacheConfig.getCache()).thenReturn(jedisPool);
        when(jedisPool.getResource()).thenReturn(jedis);
        cacheLookup = new CacheLookup("localhost", 6379, 2000) {
            @Override
            protected CacheConfig getCacheConfig() {
                return cacheConfig;
            }
        };
    }

    @Test
    void testLookupKeyExists() {
        String key = "testKey";
        String expectedValue = "testValue";
        when(jedis.get(key)).thenReturn(expectedValue);
        String result = cacheLookup.lookup(key);
        assertEquals(expectedValue, result);
        verify(jedis).get(key);
    }

    @Test
    void testLookupKeyDoesNotExist() {
        String key = "missingKey";
        when(jedis.get(key)).thenReturn(null);
        String result = cacheLookup.lookup(key);
        assertEquals(null, result);
        verify(jedis).get(key);
    }

    @Test
    void testLookupRedisException() {
        String key = "errorKey";
        when(jedis.get(key)).thenThrow(new RuntimeException("Redis connection error"));
        String result = cacheLookup.lookup(key);
        assertEquals(null, result);
        verify(jedis).get(key);
    }
}