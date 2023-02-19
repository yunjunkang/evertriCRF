package com.evertri.ecrf.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "medical_history")
    private String medicalHistory;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Consent> consents;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_id")
    private Study study;

    //default constructor
    public Patient() {
    }

    //constructor with name and date of birth
    public Patient(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //getter and setter for id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //getter and setter for date of birth
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //getter and setter for medical history
    public String getMedicalHistory() {
        return medicalHistory;
    }
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    //getter and setter for consents list
    public List<Consent> getConsents() {
        return consents;
    }
    public void setConsents(List<Consent> consents) {
        this.consents = consents;
    }

    //custom method to add a consent to the patient's consents list
    public void addConsent(Consent consent) {
        consents.add(consent);
        consent.setPatient(this);
    }

    //custom method to remove a consent from the patient's consents list
    public void removeConsent(Consent consent) {
        consents.remove(consent);
        consent.setPatient(null);
    }
}
