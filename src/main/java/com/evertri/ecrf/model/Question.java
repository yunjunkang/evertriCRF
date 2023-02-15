package com.evertri.ecrf.model;

import jakarta.persistence.*;


/**
 * Question class represents a question in the form
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String questionText;
    private QuestionType questionType;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="form_id")
    private Form form;

    /**
     * No-arg constructor for Question
     */
    public Question() {}

    /**
     * Constructor for Question
     * @param questionText the text of the question
     * @param questionType the type of question (e.g. multiple choice, numerical answer, string answer)
     */
    public Question(String questionText, QuestionType questionType) {
        this.questionText = questionText;
        this.questionType = questionType;
    }

    /**
     * Get the ID of the question
     * @return the ID of the question
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the question
     * @param id the ID to set for the question
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the text of the question
     * @return the text of the question
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Set the text of the question
     * @param questionText the text to set for the question
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    /**
     * Get the type of question
     * @return the type of question
     */
    public QuestionType getQuestionType() {
        return questionType;
    }

    /**
     * Set the type of question
     * @param questionType the type to set for the question
     */
    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    /**
     * Get the form that the question belongs to
     * @return the form that the question belongs to
     */
    public Form getForm() {
        return form;
    }

    /**
     * Set the form that the question belongs to
     * @param form the form to set for the question
     */
    public void setForm(Form form) {
        this.form = form;
    }

    /**
     * Enum representing the type of question
     */
    public enum QuestionType {
        MULTIPLE_CHOICE, NUMERICAL_ANSWER, STRING_ANSWER, MULTIPLE_CHOICE_WITH_OTHER
    }
}
