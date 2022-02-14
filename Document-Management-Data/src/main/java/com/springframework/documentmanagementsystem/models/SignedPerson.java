package com.springframework.documentmanagementsystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "signed_person")
public class SignedPerson extends Employee{

    @Column(name = "position")
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
