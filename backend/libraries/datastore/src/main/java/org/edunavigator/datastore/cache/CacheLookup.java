package org.edunavigator.datastore.cache;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
public abstract class CacheLookup {
    private final CacheConfig cacheConfig;
    public CacheLookup(@Value("${cache.redis.host}") String host,
                       @Value("${cache.redis.port}") int port,
                       @Value("${cache.redis.timeout}")int timeout){
        cacheConfig = new CacheConfig(host,port,timeout);
    }

    public String lookup(String key){
        try(Jedis lookup = cacheConfig.getCache().getResource()){
            return lookup.get(key);
        } catch (Exception e) {
            System.err.println("Error during cache lookup: " + e.getMessage());
            return null;
        }
    }

    protected abstract CacheConfig getCacheConfig();
}
