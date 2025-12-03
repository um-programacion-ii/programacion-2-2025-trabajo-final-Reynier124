package com.mycompany.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProxyWebClientConfig {

    @Bean
    public WebClient proxyWebClient(){
        return WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build();
    }
}
