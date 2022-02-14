package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import org.springframework.data.repository.CrudRepository;

public interface PreparedPersonRepository extends CrudRepository<PreparedPerson, Long> {
}
