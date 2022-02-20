package com.springframework.documentmanagementsystem.models;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "prepared_person")
public class PreparedPerson extends Employee{

    @Builder
    public PreparedPerson(Long id, String firstName, String lastName, String email, String phone) {
        super(id, firstName, lastName, email, phone);
    }
}
