package com.mycompany.myapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProxyWebClientConfig {

    @Value("${proxy.base-url}")
    private String proxyBaseUrl;

    @Bean
    public WebClient proxyWebClient() {
        return WebClient.builder()
            .baseUrl(proxyBaseUrl)
            .build();
    }
}
