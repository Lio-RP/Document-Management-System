package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.repositories.AgreementDocumentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgreementDocumentSDJpaServiceTest {

    @Mock
    AgreementDocumentRepository repository;

    @InjectMocks
    AgreementDocumentSDJpaService jpaService;

    Set<AgreementDocuments> agreementDocuments;

    @BeforeEach
    void setUp(){
        agreementDocuments = new HashSet<>();
        agreementDocuments.add(AgreementDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build());

        agreementDocuments.add(AgreementDocuments.builder().id(2L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build());

    }

    @Test
    void save(){
        AgreementDocuments agreementDocuments = AgreementDocuments.builder()
                .id(3L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        when(repository.save(any())).thenReturn(agreementDocuments);

        AgreementDocuments savedDoc = jpaService.save(agreementDocuments);

        assertNotNull(savedDoc);
        assertEquals(3L, savedDoc.getId());
        verify(repository, times(1)).save(any());
    }

    @Test
    void findAll(){
        when(repository.findAll()).thenReturn(agreementDocuments);

        Set<AgreementDocuments> docs = jpaService.findAll();

        assertEquals(2, docs.size());

    }

    @Test
    void findById(){
        AgreementDocuments doc = AgreementDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        when(repository.findById(1L)).thenReturn(Optional.of(doc));

        AgreementDocuments foundedDocById = jpaService.findById(1L);

        assertEquals(1L, foundedDocById.getId());

    }

    @Test
    void delete(){

        AgreementDocuments doc = AgreementDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        jpaService.delete(doc);

        verify(repository).delete(any());

        //assertNull();

    }

    @Test
    void deleteById(){

        AgreementDocuments doc = AgreementDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        jpaService.deleteById(doc.getId());

        verify(repository, times(1)).deleteById(anyLong());

    }
}
