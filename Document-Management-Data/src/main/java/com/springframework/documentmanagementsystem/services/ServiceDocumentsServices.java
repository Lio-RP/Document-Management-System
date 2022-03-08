package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.ServiceDocuments;

public interface ServiceDocumentsServices extends CrudServices<ServiceDocuments, Long>{

    ServiceDocuments findByRegistrationNumber(int registrationNumber);

}
