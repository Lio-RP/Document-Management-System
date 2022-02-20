package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AgreementDocumentServiceMapTest {

    @Mock
    AgreementDocumentsServices agreementDocumentsServices;

    @Mock
    PreparedPersonServices preparedPersonServices;

    @Mock
    SignedPersonServices signedPersonServices;

    @InjectMocks
    AgreementDocumentServiceMap DocumentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}