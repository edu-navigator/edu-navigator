package org.edunavigator.datastore.cache;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CacheConfig {
    private final JedisPool jedis;
    public CacheConfig(String host, int port,int connectionTimeout){
        jedis = new JedisPool(new JedisPoolConfig(), host, port, connectionTimeout);
    }

    public JedisPool getCache(){
        return jedis;
    }
}
