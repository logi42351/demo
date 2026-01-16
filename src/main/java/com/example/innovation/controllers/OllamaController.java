package com.example.innovation.controllers;

import com.example.innovation.dto.CodingQuestionRequest;
import com.example.innovation.service.CodingQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {

    @Autowired
    CodingQuestionService codingQuestionService;

    @PostMapping("/validate")
    public ResponseEntity<String> check(@RequestBody CodingQuestionRequest codingQuestionRequest) {
        return ResponseEntity.ok(codingQuestionService.validateQuestion(codingQuestionRequest));
    }
}
