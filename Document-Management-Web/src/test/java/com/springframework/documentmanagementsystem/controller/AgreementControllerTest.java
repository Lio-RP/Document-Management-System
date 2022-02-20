package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class AgreementControllerTest {

    @Mock
    AgreementDocumentsServices agreementDocumentsServices;

    @InjectMocks
    AgreementController controller;

    MockMvc mockMvc;

    Set<AgreementDocuments> agreementDocuments;

    @BeforeEach
    void setUp() {

        agreementDocuments = new HashSet<>();
        agreementDocuments.add(AgreementDocuments.builder().id(1L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build());

        agreementDocuments.add(AgreementDocuments.builder().id(2L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getDocuments() throws Exception {
        when(agreementDocumentsServices.findAll()).thenReturn(agreementDocuments);

        mockMvc.perform(get("/agreement"))
                .andExpect(status().isOk())
                .andExpect(view().name("agreement/index"))
                .andExpect(model().attribute("listDocuments", hasSize(2)));
    }

    @Test
    void getDocumentsByIndex() throws Exception {
        when(agreementDocumentsServices.findAll()).thenReturn(agreementDocuments);

        mockMvc.perform(get("/agreement/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("agreement/index"))
                .andExpect(model().attribute("listDocuments", hasSize(2)));
    }
}