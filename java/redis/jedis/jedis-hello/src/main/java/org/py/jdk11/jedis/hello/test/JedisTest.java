package org.py.jdk11.jedis.hello.test;

import lombok.Value;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {

    @Test
    public void testJedisPool() {
        String host = "";
        Integer port = 1;
        Integer maxTotal = 1;
        Integer maxIdle = 1;
        Integer minIdle = 1;
        Integer timeOut = 1;
        JedisPool jedisPool;
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        jedisPool = new JedisPool(config, host, port, timeOut);
        Jedis resource = jedisPool.getResource();
        resource.close();
    }



}
