package com.evertri.ecrf.controller;

import com.evertri.ecrf.model.Question;
import com.evertri.ecrf.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Get all questions
    @GetMapping
    public List<Question> findAll() {
        return questionService.findAll();
    }

    // Create a new question
    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    // Get a single question by id
    @GetMapping("/{id}")
    public Optional<Question> findById(@PathVariable(value = "id") Long questionId) {
        return questionService.findById(questionId);
    }

    // Update a question
    @PutMapping("/{id}")
    public Question update(@PathVariable(value = "id") Long questionId, @RequestBody Question questionDetails) {
        return questionService.update(questionId, questionDetails);
    }

    // Delete a question
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long questionId) {
        questionService.deleteById(questionId);
    }
}
