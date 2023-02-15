package com.evertri.ecrf.service;

import com.evertri.ecrf.model.Form;
import com.evertri.ecrf.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    /**
     * Method to find all forms
     * @return List of forms
     */
    public List<Form> findAll() {
        return formRepository.findAll();
    }
    /**
     * Method to create a new form
     * @param form form object
     * @return created form object
     */
    public Form create(Form form) {
        return formRepository.save(form);
    }

    /**
     * Method to save a form
     * @param form form object
     * @return saved form object
     */
    public Form save(Form form) {
        return formRepository.save(form);
    }

    /**
     * Method to find a form by its id
     *
     * @param id form id
     * @return form object
     */
    public Optional<Form> findById(Long id) {
        return formRepository.findById(id);
    }

    /**
     * Method to delete a form by its id
     * @param id form id
     */
    public void deleteById(Long id) {
        formRepository.deleteById(id);
    }

    /**
     * Method to update a form
     * @param id form id
     * @param form updated form object
     * @return updated form object
     */
    public Form update(Long id, Form form) {
        Form existingForm = formRepository.findById(id).orElse(null);
        if (existingForm == null) {
            return null;
        }
        form.setId(id);
        return formRepository.save(form);
    }
}
