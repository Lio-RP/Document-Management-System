package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.repositories.AgreementDocumentRepository;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@Profile("springdatajpa")
public class AgreementDocumentSDJpaService implements AgreementDocumentsServices {

    private final AgreementDocumentRepository agreementDocumentRepository;

    public AgreementDocumentSDJpaService(AgreementDocumentRepository agreementDocumentRepository) {
        this.agreementDocumentRepository = agreementDocumentRepository;
    }

    @Override
    public AgreementDocuments save(AgreementDocuments object) {
        log.debug("Document Saved................");
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

    @Override
    public List<AgreementDocuments> findByContractorLike(String contractor) {
        return agreementDocumentRepository.findByContractorLike(contractor);
    }
}
