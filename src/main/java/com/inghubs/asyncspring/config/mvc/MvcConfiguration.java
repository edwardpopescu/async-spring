package com.inghubs.asyncspring.config.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executor;

@Configuration
@EnableWebMvc
@EnableAsync
@Slf4j
public class MvcConfiguration implements WebMvcConfigurer {

    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        final int numOfAvailableProcessors = Runtime.getRuntime().availableProcessors();
        log.info("available processors {}", numOfAvailableProcessors);
        executor.setCorePoolSize(numOfAvailableProcessors * 20);
        executor.setMaxPoolSize(numOfAvailableProcessors * 180);
        executor.setQueueCapacity(10000);
        executor.setThreadNamePrefix("MvcAsyncThread-");
        executor.initialize();
        return executor;
    }
}
