package com.baseknow.redis;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.core.RBuckets;
import org.redisson.core.RLock;

import java.util.concurrent.TimeUnit;

public class RedissionTest {

    public static void main(String[] args) throws Exception{
        Config config=new Config();
        config.useSingleServer().setConnectTimeout(2000).setConnectionPoolSize(5).setAddress("127.0.0.1:6379");
        RedissonClient redisson= Redisson.create(config);
        RLock redissonLock = redisson.getLock("lock");
        redissonLock.lockAsync();
        redissonLock.tryLock(1,3,TimeUnit.DAYS);
        final boolean locked = redissonLock.isLocked();
        System.out.println(locked);
       // redissonLock.unlock();

        System.out.println(redisson);
    }
}
