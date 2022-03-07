package com.springframework.documentmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Documents extends BaseEntity{

    public Documents(Long id, int registrationNumber, LocalDate registrationDate,
                     String typeDocument, String stateDocument, SignedPerson singedPerson,
                     PreparedPerson preparedPerson, int numberSheets, String summery) {
        super(id);
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.typeDocument = typeDocument;
        this.stateDocument = stateDocument;
        this.signedPerson = singedPerson;
        this.preparedPerson = preparedPerson;
        this.numberSheets = numberSheets;
        this.summery = summery;
    }

    @Column(name = "registration_number")
    private int registrationNumber;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "type_document")
    private String typeDocument;

    @Column(name = "state_document")
    private String stateDocument;

    @ManyToOne
    @JoinColumn(name = "signed_person_id")
    private SignedPerson signedPerson;

    @ManyToOne
    @JoinColumn(name = "prepared_person_id")
    private PreparedPerson preparedPerson;

    @Column(name = "number_sheets")
    private int numberSheets;

    @Column(name = "summery")
    private String summery;

}
