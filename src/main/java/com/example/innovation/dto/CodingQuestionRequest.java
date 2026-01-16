package com.example.innovation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CodingQuestionRequest {

    private String question;
    private String description;
    private List<String> sampleInputs;
    private List<String> sampleOutputs;
}
