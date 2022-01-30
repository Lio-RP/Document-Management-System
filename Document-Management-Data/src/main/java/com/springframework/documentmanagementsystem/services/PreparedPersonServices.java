package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.PreparedPerson;

public interface PreparedPersonServices extends CrudServices<PreparedPerson, Long> {

    PreparedPerson findByLastName(String lastName);
}
