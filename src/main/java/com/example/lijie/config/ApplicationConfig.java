package com.example.lijie.config;

import com.example.lijie.config.interceptor.LoginInterceptor;
import com.example.lijie.config.interceptor.SignInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@ComponentScan({"com.example.lijie.service"})
public class ApplicationConfig {
    @Autowired
    private Environment env;



    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(12);
        taskExecutor.setMaxPoolSize(24);
        taskExecutor.setKeepAliveSeconds(180);
        taskExecutor.setQueueCapacity(24);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return taskExecutor;
    }



    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public SignInterceptor signInterceptor() {
        return new SignInterceptor();
    }

    //@Bean
    //public MethodValidationPostProcessor methodValidationPostProcessor() {
    //    return new MethodValidationPostProcessor();
    //}
}