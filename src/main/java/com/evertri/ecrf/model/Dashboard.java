package com.evertri.ecrf.model;

public class Dashboard {

    private Form form;

    //constructor with form
    public Dashboard(Form form) {
        this.form = form;
    }

    //getter for form
    public Form getForm() {
        return form;
    }

    //setter for form
    public void setForm(Form form) {
        this.form = form;
    }

    //method to generate different dashboards based on the form
    public void generateDashboard() {
        switch(form.getName()) {
            case "Form1":
                //generate dashboard for Form1
                break;
            case "Form2":
                //generate dashboard for Form2
                break;
            //and so on
        }
    }
}
