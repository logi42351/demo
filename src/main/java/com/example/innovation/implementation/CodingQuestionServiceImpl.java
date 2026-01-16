package com.example.innovation.implementation;


import com.example.innovation.config.ollama.OllamaClient;
import com.example.innovation.dto.CodingQuestionRequest;
import com.example.innovation.service.CodingQuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodingQuestionServiceImpl implements CodingQuestionService {

    private final OllamaClient ollamaClient;

    public CodingQuestionServiceImpl(OllamaClient ollamaClient) {
        this.ollamaClient = ollamaClient;
    }

    @Override
    public String validateQuestion(
            CodingQuestionRequest codingQuestionRequest
    ) {
        String prompt ="""
        Your task is to validate a coding question and its description, and infer the program logic from sample input/output.
        Instructions:
            1. Analyze the question, description, and sample inputs/outputs.
            2. Rewrite the question and description if unclear or incomplete.
            3. Infer the logic behind the program from the sample input/output.
            4. Include a "logic" field explaining the **step-by-step approach to solve the problem** in plain language or pseudo-code.
            5. Accuracy score should evaluate the description provided and logical correctness of the question with the input and output match
            6. Provide a JSON output in the following format:

        Examples:
        Question: "Array Sort"
        Description: "Given an array just print it"
        Sample Input/Output Pairs:
        1. Input: [3,1,2] => Output: [1,2,3]
        2. Input: [5,4,6] => Output: [4,5,6]
        Output:
        {
            "valid": true,
            "correctedQuestion": "How can you sort an array of numbers in Java?",
            "correctedDescription": "Write a Java program to sort arrays of integers in ascending order.",
            "sampleInputs": [[3,1,2],[5,4,6]],
            "sampleOutputs": [[1,2,3],[4,5,6]],
            "accuracy": 0.92,
            "logic": "<Logic to solve this question to be inserted here>"
        }

        Now validate:
        Question: "%s"
        Description: "%s"
        Sample Input/Output Pairs:%s
        """.formatted(
                        codingQuestionRequest.getQuestion(),
                        codingQuestionRequest.getDescription(),
                        getInputOutPut(codingQuestionRequest)
            );

            return ollamaClient.generate(prompt);
        }

        private static String getInputOutPut(CodingQuestionRequest codingQuestionRequest) {


            List<String> ioPairs = new ArrayList<>();
            for (int i = 0; i < codingQuestionRequest.getSampleInputs().size(); i++) {
                ioPairs.add(String.format("%d. Input: %s => Output: %s",
                        i + 1,
                        codingQuestionRequest.getSampleInputs().get(i),
                        codingQuestionRequest.getSampleOutputs().get(i)
                ));
            }
            return String.join("\n", ioPairs);
        }
    }
