package com.evertri.ecrf.controller;

import com.evertri.ecrf.model.Answer;
import com.evertri.ecrf.service.AnswerService;
import com.evertri.ecrf.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for Answer model
 */
@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    /**
     * Autowired answer service
     */
    @Autowired
    private AnswerService answerService;

    /**
     * Method to retrieve all answers
     * @return list of answers
     */
    @GetMapping
    public List<Answer> findAll() {
        return answerService.findAll();
    }

    /**
     * Method to retrieve answer by id
     * @param id answer id
     * @return answer object
     */
    @GetMapping("/{id}")
    public Answer findById(@PathVariable Long id) {
        return answerService.findById(id);
    }

    /**
     * Method to save answer
     * @param answer answer object
     * @return saved answer object
     */
    @PostMapping
    public Answer save(@RequestBody Answer answer) {
        return answerService.save(answer);
    }

    /**
     * Method to update answer
     * @param id answer id
     * @param answer answer object
     * @return updated answer object
     */
    @PutMapping("/{id}")
    public Answer update(@PathVariable Long id, @RequestBody Answer answer) {
        return answerService.update(id, answer);
    }


    /**
     * Method to delete answer by id
     * @param id answer id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        answerService.deleteById(id);
    }

    /**
     * Method to find all answers for a given form
     * @param formId form id
     * @return list of answers
     */
    @GetMapping("/form/{formId}")
    public List<Answer> findByFormId(@PathVariable Long formId) {
        return answerService.findByFormId(formId);
    }

    /**
     * Method to find all answers for a given question
     * @param questionId question id
     * @return list of answers
     */
    @GetMapping("/question/{questionId}")
    public List<Answer> findByQuestionId(@PathVariable Long questionId) {
        return answerService.findByQuestionId(questionId);
    }
}
