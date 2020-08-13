package com.haulmont.model.entities;

public class Patient extends Human {

    private String  number;

    public Patient(long id, String firstName, String lastName, String dadsName, String number) {
        super(id, firstName, lastName, dadsName);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    void setNumber(String number) {
        this.number = number;
    }

    public String toString(){
        return getLastName() + " " + getFirstName().charAt(0) + ". " + getDadsName().charAt(0) + ".  t: " + number;
    }
}
