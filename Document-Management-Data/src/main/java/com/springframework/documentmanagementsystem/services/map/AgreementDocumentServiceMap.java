package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.services.CrudServices;

import java.util.Set;

public class AgreementDocumentServiceMap extends AbstractServiceMap<AgreementDocuments, Long> implements CrudServices<AgreementDocuments, Long> {

    @Override
    public AgreementDocuments save(AgreementDocuments agreementDocuments) {
        return super.save(agreementDocuments.getId(), agreementDocuments);
    }

    @Override
    public AgreementDocuments findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<AgreementDocuments> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(AgreementDocuments agreementDocuments) {
        super.delete(agreementDocuments);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
