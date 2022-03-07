package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;

import java.util.List;

public interface AgreementDocumentsServices extends CrudServices<AgreementDocuments, Long> {

    List<AgreementDocuments> findByContractorLike(String contractor);
}
