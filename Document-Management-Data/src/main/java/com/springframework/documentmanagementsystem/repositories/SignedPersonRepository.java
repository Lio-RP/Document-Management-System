package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.SignedPerson;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SignedPersonRepository extends CrudRepository<SignedPerson, Long> {

    Optional<SignedPerson> findByLastName(String lastName);
}
