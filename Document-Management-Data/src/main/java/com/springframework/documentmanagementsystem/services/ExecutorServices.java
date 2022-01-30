package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.Executor;

public interface ExecutorServices extends CrudServices<Executor, Long> {

    Executor findByLastName(String lastName);
}
