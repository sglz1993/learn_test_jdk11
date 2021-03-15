package org.py.spring.jetcache.hello.config;

import org.py.common.util.LogUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public void initLogger() {
        LogUtil.addLoggerFilter();
    }

}
