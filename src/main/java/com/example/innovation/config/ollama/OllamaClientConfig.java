package com.example.innovation.config.ollama;

import com.example.innovation.utils.ollama.OllamaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class OllamaClientConfig {

    private final OllamaProperties properties;

    public OllamaClientConfig(OllamaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public RestClient ollamaRestClient(RestClient.Builder builder) {
        return builder
                .baseUrl(properties.getBaseUrl())          // Base URL from configuration
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
