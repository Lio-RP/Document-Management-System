package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.SignedPerson;

public interface SignedPersonServices extends CrudServices<SignedPerson, Long> {

    SignedPerson findByLastName(String lastName);
}
