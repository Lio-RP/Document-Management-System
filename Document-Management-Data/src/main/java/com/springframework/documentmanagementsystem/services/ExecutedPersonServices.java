package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.ExecutedPerson;

public interface ExecutedPersonServices extends CrudServices<ExecutedPerson, Long> {

    ExecutedPerson findByLastName(String lastName);
}
