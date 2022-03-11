package com.springframework.documentmanagementsystem.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
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
                              String contractor, BigDecimal amount) {
        super(id, registrationNumber, registrationDate,
                typeDocument, stateDocument, singedPerson,
                preparedPerson, numberSheets, summery);
        this.typeAgreement = typeAgreement;
        this.deadlineAgreement = deadlineAgreement;
        this.contractor = contractor;
        this.amount = amount;
    }

    @Column(name = "type_agreement")
    @NotBlank
    @Size(min = 5, max = 255)
    private String typeAgreement;

    @Column(name = "deadline_agreement")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate deadlineAgreement;

    @Column(name = "contractor")
    @NotBlank
    @Size(min = 3, max = 255)
    private String contractor;

    @Column(name = "amount")
    private BigDecimal amount;

}