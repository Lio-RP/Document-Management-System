package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.Executor;

import java.util.Set;

public interface ExecutorServices {

    Executor findByLastName(String lastName);

    Executor save(Executor executor);

    Executor findById(Long id);

    Set<Executor> findAll();
}
