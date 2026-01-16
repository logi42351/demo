package com.example.innovation.dto;

public record OllamaGenerateRequest(
        String model,
        String prompt,
        boolean stream,
        Options options
) {
    public record Options(Double temperature) {

    }
}

