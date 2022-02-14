package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.repositories.AgreementDocumentRepository;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;

import java.util.HashSet;
import java.util.Set;

public class AgreementDocumentSDJpaService implements AgreementDocumentsServices {

    private final AgreementDocumentRepository agreementDocumentRepository;

    public AgreementDocumentSDJpaService(AgreementDocumentRepository agreementDocumentRepository) {
        this.agreementDocumentRepository = agreementDocumentRepository;
    }

    @Override
    public AgreementDocuments save(AgreementDocuments object) {
        return agreementDocumentRepository.save(object);
    }

    @Override
    public AgreementDocuments findById(Long aLong) {
        return agreementDocumentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<AgreementDocuments> findAll() {
        Set<AgreementDocuments> agreementDocuments = new HashSet<>();
        agreementDocumentRepository.findAll().forEach(agreementDocuments::add);
        return agreementDocuments;
    }

    @Override
    public void delete(AgreementDocuments object) {
        agreementDocumentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        agreementDocumentRepository.deleteById(aLong);
    }
}
