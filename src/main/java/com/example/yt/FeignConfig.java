package com.example.yt;

import com.example.yt.translation.YandexConfig;
import feign.Logger;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FeignConfig {

    private final YandexConfig yandexConfig;

    @Bean
    public RequestInterceptor interceptor(){
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Api-Key " + yandexConfig.getKey());
        };
    }

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
