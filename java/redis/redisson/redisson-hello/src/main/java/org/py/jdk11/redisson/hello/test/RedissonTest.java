package org.py.jdk11.redisson.hello.test;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

public class RedissonTest {

    @Test
    public void testRedissonNettyPool() {
        Config config = new Config();
        config.setThreads(10);
        config.setNettyThreads(10);
//        config.setExecutor();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://127.0.0.1:6379")
                .setConnectionMinimumIdleSize(1)
                .setConnectionPoolSize(2)
//                .setIdleConnectionTimeout(10)
                .setConnectTimeout(10)
                .setTimeout(10)
                .setDatabase(1)
                .setClientName("test");
        RedissonClient redissonClient = Redisson.create(config);
        RLock testjdk11Lock = redissonClient.getLock("testjdk11Lock");
        testjdk11Lock.unlock();
        redissonClient.shutdown();
    }

}
