package com.springframework.documentmanagementsystem.models;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "service_documents")
public class ServiceDocuments extends Documents{

    @Builder
    public ServiceDocuments(Long id, int registrationNumber, LocalDate registrationDate,
                            String typeDocument, String stateDocument, SignedPerson singedPerson,
                            PreparedPerson preparedPerson, int numberSheets, String summery) {
        super(id, registrationNumber, registrationDate, typeDocument,
                stateDocument, singedPerson, preparedPerson, numberSheets, summery);
    }
}
