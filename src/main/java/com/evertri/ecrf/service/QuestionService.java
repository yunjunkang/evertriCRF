package com.evertri.ecrf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertri.ecrf.model.Question;
import com.evertri.ecrf.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    // Returns all questions
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    // Returns question by ID
    public Optional<Question> findById(Long questionId) {
        return questionRepository.findById(questionId);
    }

    // Creates new question
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    // Updates existing question
    public Question update(Long questionId, Question question) {
        question.setId(questionId);
        return questionRepository.save(question);
    }

    // Deletes question by ID
    public void deleteById(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    // Returns questions by form ID
    public List<Question> findByFormId(Long formId) {
        return questionRepository.findByFormId(formId);
    }
}
