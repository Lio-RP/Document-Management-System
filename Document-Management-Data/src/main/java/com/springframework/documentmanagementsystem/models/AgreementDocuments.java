package com.springframework.documentmanagementsystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "agreement_documents")
public class AgreementDocuments extends Documents{

    @Column(name = "type_agreement")
    private String typeAgreement;

    @Column(name = "deadline_agreement")
    public LocalDate deadlineAgreement;

    @Column(name = "contractor")
    private String contractor;

    @Column(name = "amount")
    private long amount;

    public String getTypeAgreement() {
        return typeAgreement;
    }

    public void setTypeAgreement(String typeAgreement) {
        this.typeAgreement = typeAgreement;
    }

    public LocalDate getDeadlineAgreement() {
        return deadlineAgreement;
    }

    public void setDeadlineAgreement(LocalDate deadlineAgreement) {
        this.deadlineAgreement = deadlineAgreement;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}