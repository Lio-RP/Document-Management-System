package com.springframework.documentmanagementsystem.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "signed_person")
public class SignedPerson extends Employee{

    @Builder
    public SignedPerson(Long id, String firstName, String lastName,
                        String email, String phone, String position) {
        super(id, firstName, lastName, email, phone);
        this.position = position;
    }

    @Column(name = "position")
    private String position;
}
