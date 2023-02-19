package com.evertri.ecrf.controller;

import com.evertri.ecrf.model.Consent;
import com.evertri.ecrf.service.ConsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consents")
public class ConsentController {

    @Autowired
    private ConsentService consentService;

    @GetMapping("/{id}")
    public ResponseEntity<Consent> findById(@PathVariable Long id) {
        Consent consent = consentService.findById(id);
        return consent != null ? ResponseEntity.ok(consent) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Consent> create(@RequestBody Consent consent) {
        Consent createdConsent = consentService.create(consent);
        return new ResponseEntity<>(createdConsent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consent> update(@PathVariable Long id, @RequestBody Consent consent) {
        Consent updatedConsent = consentService.update(id, consent);
        return updatedConsent != null ? ResponseEntity.ok(updatedConsent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        consentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
