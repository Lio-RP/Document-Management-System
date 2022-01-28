package com.springframework.documentmanagementsystem.models;

import java.time.LocalDate;

public class AgreementDocuments extends Documents{

    private String typeAgreement;
    public LocalDate deadlineAgreement;
    private String contractor;
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