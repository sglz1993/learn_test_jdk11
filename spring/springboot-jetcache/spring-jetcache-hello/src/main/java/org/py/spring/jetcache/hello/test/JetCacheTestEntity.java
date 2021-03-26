package org.py.spring.jetcache.hello.test;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;

public class JetCacheTestEntity {

    @CreateCache(expire = 100)
    private Cache<Long, UserDO> userCache;

    @CreateCache(name = "UserService.userCache", expire = 100, cacheType = CacheType.BOTH, localLimit = 50)
    private Cache<Long, UserDO> userCache2;


    public interface UserService {
        @Cached(name = "UserService.getUserById", expire = 3600)
        UserDO getUserById(long userId);
    }

    static class UserDO {
    }
}
