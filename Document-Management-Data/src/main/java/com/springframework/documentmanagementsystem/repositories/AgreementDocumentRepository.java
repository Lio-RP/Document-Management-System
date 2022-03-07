package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgreementDocumentRepository extends CrudRepository<AgreementDocuments, Long> {

    List<AgreementDocuments> findByContractorLike(String contractor);
}
