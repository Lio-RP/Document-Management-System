package com.springframework.documentmanagementsystem.models;

import java.time.LocalDate;

public class Documents {

    private int registrationNumber;
    private LocalDate registrationDate;
    private String typeDocument;
    private String stateDocument;
    private String prepared;
    private String executed;
    private int numberSheets;
    private String summery;

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getStateDocument() {
        return stateDocument;
    }

    public void setStateDocument(String stateDocument) {
        this.stateDocument = stateDocument;
    }

    public String getPrepared() {
        return prepared;
    }

    public void setPrepared(String prepared) {
        this.prepared = prepared;
    }

    public String getExecuted() {
        return executed;
    }

    public void setExecuted(String executed) {
        this.executed = executed;
    }

    public int getNumberSheets() {
        return numberSheets;
    }

    public void setNumberSheets(int numberSheets) {
        this.numberSheets = numberSheets;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }
}
