package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ServiceDocumentsServiceMapTest {

    ServiceDocumentsServiceMap documentService;


    @BeforeEach
    void setUp() {

        documentService = new ServiceDocumentsServiceMap(new SignedPersonServiceMap(),
                new PreparedPersonServiceMap());

        documentService.save(ServiceDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build());
    }

    @Test
    void saveExistedId() {
        Long id = 2L;

        ServiceDocuments serviceDocuments = ServiceDocuments.builder().id(id)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        ServiceDocuments savedDocument = documentService.save(serviceDocuments);

        assertNotNull(savedDocument);
        assertEquals(serviceDocuments.getId(), savedDocument.getId());
        assertEquals(2, documentService.findAll().size());
    }


    @Test
    void saveNoId() {
        ServiceDocuments serviceDocuments = ServiceDocuments.builder()
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        assertEquals(null, serviceDocuments.getId());

        ServiceDocuments savedDocument = documentService.save(serviceDocuments);

        assertNotNull(serviceDocuments.getId());

        assertNotNull(savedDocument);
        assertEquals(serviceDocuments.getId(), savedDocument.getId());
        assertEquals(2, documentService.findAll().size());
    }

    @Test
    void findById() {

        ServiceDocuments document = documentService.findById(1L);

        assertEquals(1, document.getId());
    }

    @Test
    void findAll() {
        Set<ServiceDocuments> serviceDocuments = documentService.findAll();

        assertNotEquals(0, serviceDocuments.size());

        assertEquals(1, serviceDocuments.size());
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