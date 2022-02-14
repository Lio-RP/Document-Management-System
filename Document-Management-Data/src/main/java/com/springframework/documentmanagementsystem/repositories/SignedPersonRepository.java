package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.SignedPerson;
import org.springframework.data.repository.CrudRepository;

public interface SignedPersonRepository extends CrudRepository<SignedPerson, Long> {
}
