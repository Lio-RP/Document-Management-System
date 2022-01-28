package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.Prepared;

import java.util.Set;

public interface PreparedServices {

    Prepared findByLastName(String lastName);

    Prepared save(Prepared executor);

    Prepared findById(Long id);

    Set<Prepared> findAll();
}
