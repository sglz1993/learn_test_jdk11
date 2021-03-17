package org.py.spring.jetcache.hello.test;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.redis.RedisCacheBuilder;
import com.alicp.jetcache.support.FastjsonKeyConvertor;
import com.alicp.jetcache.support.JavaValueDecoder;
import com.alicp.jetcache.support.JavaValueEncoder;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

public class SimpleJetcacheJavaTest {

    @Test
    public void test() {
        GenericObjectPoolConfig pc = new GenericObjectPoolConfig();
        pc.setMinIdle(2);
        pc.setMaxIdle(10);
        pc.setMaxTotal(10);
        JedisPool pool = new JedisPool(pc, "localhost", 6379);
        Cache<Long, JetCacheTestEntity.UserDO> userCache = RedisCacheBuilder.createRedisCacheBuilder()
                .keyConvertor(FastjsonKeyConvertor.INSTANCE)
                .valueEncoder(JavaValueEncoder.INSTANCE)
                .valueDecoder(JavaValueDecoder.INSTANCE)
                .jedisPool(pool)
                .keyPrefix("userCache-")
                .expireAfterWrite(200, TimeUnit.SECONDS)
                .buildCache();
//        AutoReleaseLock autoReleaseLock = userCache.tryLockAndRun();
    }

}
