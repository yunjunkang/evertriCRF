package com.evertri.ecrf.controller;

import com.evertri.ecrf.model.Study;
import com.evertri.ecrf.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studies")
public class StudyController {

    // inject the StudyService instance
    @Autowired
    private StudyService studyService;

    // handles the HTTP GET request to retrieve all studies
    @GetMapping
    public List<Study> getAllStudies() {
        return studyService.findAll();
    }

    // handles the HTTP POST request to create a new study
    @PostMapping
    public Study createStudy(@RequestBody Study study) {
        return studyService.save(study);
    }

    // handles the HTTP GET request to retrieve a study by id
    @GetMapping("/{id}")
    public Study getStudyById(@PathVariable Long id) {
        return studyService.findById(id);
    }

    // handles the HTTP PUT request to update a study by id
    @PutMapping("/{id}")
    public Study updateStudy(@PathVariable Long id, @RequestBody Study study) {
        Study existingStudy = studyService.findById(id);
        existingStudy.setName(study.getName());
        return studyService.save(existingStudy);
    }

    // handles the HTTP DELETE request to delete a study by id
    @DeleteMapping("/{id}")
    public void deleteStudy(@PathVariable Long id) {
        studyService.deleteById(id);
    }
}
