package org.py.spring.jetcache.hello;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMethodCache(basePackages = "org.py.spring.jetcache.hello")
@EnableCreateCacheAnnotation
@SpringBootApplication
public class SpringJetcacheHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJetcacheHelloApplication.class, args);
    }

}
