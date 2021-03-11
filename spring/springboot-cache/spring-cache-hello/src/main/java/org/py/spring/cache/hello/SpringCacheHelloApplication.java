package org.py.spring.cache.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringCacheHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheHelloApplication.class, args);
    }

}
