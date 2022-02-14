package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PreparedPersonRepository extends CrudRepository<PreparedPerson, Long> {

    Optional<PreparedPerson> findByLastName(String lastName);
}
