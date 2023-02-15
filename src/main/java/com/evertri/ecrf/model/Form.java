package com.evertri.ecrf.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<Question> questions;

    // default constructor
    public Form() {}

    // constructor with name
    public Form(String name) {
        this.name = name;
    }

    // getter and setter for id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // getter and setter for the Study instance
    public Study getStudy() {
        return study;
    }
    public void setStudy(Study study) {
        this.study = study;
    }

    // getter and setter for questions list
    public List<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // custom method to add a question to the form
    public void addQuestion(Question question) {
        questions.add(question);
        question.setForm(this);
    }

    // custom method to remove a question from the form
    public void removeQuestion(Question question) {
        questions.remove(question);
        question.setForm(null);
    }
}
