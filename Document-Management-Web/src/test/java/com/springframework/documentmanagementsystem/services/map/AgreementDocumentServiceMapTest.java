package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AgreementDocumentServiceMapTest {

    AgreementDocumentServiceMap documentService;


    @BeforeEach
    void setUp() {

        documentService = new AgreementDocumentServiceMap(new PreparedPersonServiceMap(),
                new SignedPersonServiceMap());

        documentService.save(AgreementDocuments.builder().id(1L)
                        .preparedPerson(PreparedPerson.builder().build())
                        .singedPerson(SignedPerson.builder().build())
                .build());
    }

    @Test
    void saveExistedId() {
        Long id = 2L;

        AgreementDocuments agreementDocuments = AgreementDocuments.builder().id(id)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        AgreementDocuments savedDocument = documentService.save(agreementDocuments);

        assertNotNull(savedDocument);
        assertEquals(agreementDocuments.getId(), savedDocument.getId());
        assertEquals(2, documentService.findAll().size());
    }


    @Test
    void saveNoId() {
        AgreementDocuments agreementDocuments = AgreementDocuments.builder()
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        assertEquals(null, agreementDocuments.getId());

        AgreementDocuments savedDocument = documentService.save(agreementDocuments);

        assertNotNull(agreementDocuments.getId());

        assertNotNull(savedDocument);
        assertEquals(agreementDocuments.getId(), savedDocument.getId());
        assertEquals(2, documentService.findAll().size());
    }

    @Test
    void findById() {

        AgreementDocuments document = documentService.findById(1L);

        assertEquals(1, document.getId());
    }

    @Test
    void findAll() {
        Set<AgreementDocuments> agreementDocuments = documentService.findAll();

        assertNotEquals(0, agreementDocuments.size());

        assertEquals(1, agreementDocuments.size());
    }

    @Test
    void delete() {
        documentService.delete(documentService.findById(1L));

        assertEquals(0, documentService.findAll().size());
    }

    @Test
    void deleteById() {
        documentService.deleteById(1L);

        assertEquals(0, documentService.findAll().size());
    }
}