package com.evertri.ecrf.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_study", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "study_id"))
    private List<Study> studies;

    //default constructor
    public User() {
    }

    //constructor with username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //getter and setter for id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //getter and setter for username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    //getter and setter for password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //getter and setter for studies list
    public List<Study> getStudies() {
        return studies;
    }
    public void setStudies(List<Study> studies) {
        this.studies = studies;
    }

    //custom method to add a study to the user's studies list
    public void addStudy(Study study) {
        studies.add(study);
        study.getUsers().add(this);
    }

    //custom method to remove a study from the user's studies list
    public void removeStudy(Study study) {
        studies.remove(study);
        study.getUsers().remove(this);
    }

    //custom method to check if the user has authorization to view a specific study
    public boolean hasAuthorization(Study study) {
        return studies.contains(study);
    }
}
