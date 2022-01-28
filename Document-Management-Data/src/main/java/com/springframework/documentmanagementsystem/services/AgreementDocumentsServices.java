package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;

import java.util.Set;

public interface AgreementDocumentsServices {

    AgreementDocuments save(AgreementDocuments agreementDocuments);

    AgreementDocuments findDocumentById(Long id);

    Set<AgreementDocuments> findAllDocuments();
}
