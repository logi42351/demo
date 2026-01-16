package com.example.innovation.config.ollama;

import com.example.innovation.dto.OllamaGenerateRequest;
import com.example.innovation.dto.OllamaGenerateResponse;
import com.example.innovation.utils.ollama.OllamaProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Component
public class OllamaClient {

    private final RestClient restClient;
    private final OllamaProperties properties;

    public OllamaClient(RestClient restClient, OllamaProperties properties) {
        this.restClient = restClient;
        this.properties = properties;
    }

    public String generate(String prompt) {

        System.out.println(prompt);

        OllamaGenerateRequest request =
                new OllamaGenerateRequest(
                        properties.getModel(),
                        prompt,
                        false,
                        new OllamaGenerateRequest.Options(
                                properties.getTemperature()
                        )
                );

        OllamaGenerateResponse response = restClient.post()
                .uri("/api/generate")
                .body(request)
                .retrieve()
                .body(OllamaGenerateResponse.class);

        return Objects.requireNonNull(response).response();
    }

}

