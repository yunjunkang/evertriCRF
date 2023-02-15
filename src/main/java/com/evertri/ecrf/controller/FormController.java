package com.evertri.ecrf.controller;

import com.evertri.ecrf.model.Form;
import com.evertri.ecrf.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for Form model
 */
@RestController
@RequestMapping("/api/forms")
public class FormController {

    @Autowired
    private FormService formService;

    /**
     * Method to create a new form
     * @param form form object to be saved
     * @return saved form object
     */
    @PostMapping
    public ResponseEntity<Form> create(@RequestBody Form form) {
        Form savedForm = formService.create(form);
        return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
    }

    /**
     * Method to find all forms
     * @return list of all forms
     */
    @GetMapping
    public ResponseEntity<List<Form>> findAll() {
        List<Form> forms = formService.findAll();
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    /**
     * Method to find a form by its id
     * @param formId form id
     * @return form object
     */

    @GetMapping("/{id}")
    public Form getFormById(@PathVariable(value = "id") Long formId) {
        return formService.findById(formId).orElse(null);
    }

    /**
     * Method to update a form
     * @param id form id
     * @param form form object with updated values
     * @return updated form object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Form> update(@PathVariable long id, @RequestBody Form form) {
        Form updatedForm = formService.update(id, form);
        return new ResponseEntity<>(updatedForm, HttpStatus.OK);
    }

    /**
     * Method to delete a form by its id
     * @param id form id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        formService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
