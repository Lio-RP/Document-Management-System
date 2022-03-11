package com.springframework.documentmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @Min(1)
    @Max(9999)
    private int registrationNumber;

    @Column(name = "registration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

    @Column(name = "type_document")
    @NotBlank
    @Size(min = 5, max = 255)
    private String typeDocument;

    @Column(name = "state_document")
    @NotBlank
    @Size(min = 5, max = 255)
    private String stateDocument;

    @ManyToOne
    @JoinColumn(name = "signed_person_id")
    private SignedPerson signedPerson;

    @ManyToOne
    @JoinColumn(name = "prepared_person_id")
    private PreparedPerson preparedPerson;

    @Column(name = "number_sheets")
    @Min(1)
    @Max(10)
    private int numberSheets;

    @Column(name = "summery")
    @NotBlank
    @Lob
    private String summery;

}
