package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.repositories.ServiceDocumentsRepository;
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
class ServiceDocumentsSDJpaServiceTest {


    @Mock
    ServiceDocumentsRepository repository;

    @InjectMocks
    ServiceDocumentsSDJpaService jpaService;

    Set<ServiceDocuments> serviceDocuments;

    @BeforeEach
    void setUp(){
        serviceDocuments = new HashSet<>();
        serviceDocuments.add(ServiceDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build());

        serviceDocuments.add(ServiceDocuments.builder().id(2L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build());

    }

    @Test
    void save(){
        ServiceDocuments serviceDocs = ServiceDocuments.builder()
                .id(3L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        when(repository.save(any())).thenReturn(serviceDocs);

        ServiceDocuments savedDoc = jpaService.save(serviceDocs);

        assertNotNull(savedDoc);
        assertEquals(3L, savedDoc.getId());
        verify(repository, times(1)).save(any());
    }

    @Test
    void findAll(){
        when(repository.findAll()).thenReturn(serviceDocuments);

        Set<ServiceDocuments> docs = jpaService.findAll();

        assertEquals(2, docs.size());

    }

    @Test
    void findById(){
        ServiceDocuments doc = ServiceDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        when(repository.findById(1L)).thenReturn(Optional.of(doc));

        ServiceDocuments foundedDocById = jpaService.findById(1L);

        assertEquals(1L, foundedDocById.getId());

    }

    @Test
    void delete(){

        ServiceDocuments doc = ServiceDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        jpaService.delete(doc);

        verify(repository).delete(any());

        //assertNull();

    }

    @Test
    void deleteById(){

        ServiceDocuments doc = ServiceDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build();

        jpaService.deleteById(doc.getId());

        verify(repository, times(1)).deleteById(anyLong());

    }
}
