package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import org.springframework.data.repository.CrudRepository;

public interface AgreementDocumentRepository extends CrudRepository<AgreementDocuments, Long> {
}
