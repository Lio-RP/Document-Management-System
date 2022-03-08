package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import org.springframework.data.repository.CrudRepository;

public interface ServiceDocumentsRepository extends CrudRepository<ServiceDocuments, Long> {

    ServiceDocuments findByRegistrationNumber(int registrationNumber);
}
