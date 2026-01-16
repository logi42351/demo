package com.example.innovation.service;

import com.example.innovation.dto.CodingQuestionRequest;

import java.util.List;

public interface CodingQuestionService {
    String validateQuestion(
            CodingQuestionRequest codingQuestionRequest
    );
}
