package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.ServiceDocuments;

import java.util.Set;

public interface ServiceDocumentsServices {

    ServiceDocuments save(ServiceDocuments serviceDocuments);

    ServiceDocuments findDocumentById(Long id);

    Set<ServiceDocuments> findAllDocuments();
}
