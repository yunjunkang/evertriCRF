package com.evertri.ecrf.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "study")
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "study", cascade = CascadeType.ALL)
    private List<Form> forms;

    //default constructor
    public Study() {
    }

    //constructor with name
    public Study(String name) {
        this.name = name;
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

    //getter and setter for forms list
    public List<Form> getForms() {
        return forms;
    }
    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    //custom method to add a form to the study
    public void addForm(Form form) {
        forms.add(form);
        form.setStudy(this);
    }

    //custom method to remove a form from the study
    public void removeForm(Form form) {
        forms.remove(form);
        form.setStudy(null);
    }
}
