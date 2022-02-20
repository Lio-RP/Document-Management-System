package com.springframework.documentmanagementsystem.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "agreement_documents")
public class AgreementDocuments extends Documents{

    @Builder
    public AgreementDocuments(Long id, int registrationNumber,
                              LocalDate registrationDate, String typeDocument,
                              String stateDocument, SignedPerson singedPerson,
                              PreparedPerson preparedPerson, int numberSheets,
                              String summery, String typeAgreement, LocalDate deadlineAgreement,
                              String contractor, long amount) {
        super(id, registrationNumber, registrationDate,
                typeDocument, stateDocument, singedPerson,
                preparedPerson, numberSheets, summery);
        this.typeAgreement = typeAgreement;
        this.deadlineAgreement = deadlineAgreement;
        this.contractor = contractor;
        this.amount = amount;
    }

    @Column(name = "type_agreement")
    private String typeAgreement;

    @Column(name = "deadline_agreement")
    public LocalDate deadlineAgreement;

    @Column(name = "contractor")
    private String contractor;

    @Column(name = "amount")
    private long amount;

}