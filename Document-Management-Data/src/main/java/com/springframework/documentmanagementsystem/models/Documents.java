package com.springframework.documentmanagementsystem.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class Documents extends BaseEntity{

    @Column(name = "registration_number")
    private int registrationNumber;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "type_document")
    private String typeDocument;

    @Column(name = "state_document")
    private String stateDocument;

    private PreparedPerson preparedPerson;
    private SignedPerson singedPerson;

    @Column(name = "number_sheets")
    private int numberSheets;

    @Column(name = "summery")
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

    public PreparedPerson getPreparedPerson() {
        return preparedPerson;
    }

    public void setPreparedPerson(PreparedPerson preparedPerson) {
        this.preparedPerson = preparedPerson;
    }

    public SignedPerson getSingedPerson() {
        return singedPerson;
    }

    public void setSingedPerson(SignedPerson singedPerson) {
        this.singedPerson = singedPerson;
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
