package org.py.spring.cache.hello.config;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;


@Slf4j
@Configuration
public class ApplicationConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public Filter logFilter() {
        return new AbstractRequestLoggingFilter() {

            private ThreadLocal<Long> execStart = new ThreadLocal<>();

            private List<String> ignoreUrl = Lists.newArrayList("/favicon.ico");

            @Override
            protected void beforeRequest(HttpServletRequest request, String message) {
                if (!ignoreUrl.contains(request.getRequestURI())) {
                    MDC.put("request_id", UUID.randomUUID().toString().replace("-", ""));
                    execStart.set(System.currentTimeMillis());
                    log.info(" {} ", message);
                }
            }

            @Override
            protected void afterRequest(HttpServletRequest request, String message) {
                if (!ignoreUrl.contains(request.getRequestURI())) {
                    Long start = execStart.get();
                    execStart.remove();
                    log.info("exectime:{}ms, msg:{}", System.currentTimeMillis() - start, message);
                }
            }
        };
    }

}
