package com.springframework.documentmanagementsystem.services;

import java.util.Set;

public interface CrudServices<T, ID> {

    T save(T object);

    T findById(ID id);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}
