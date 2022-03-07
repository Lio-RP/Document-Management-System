package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class AgreementControllerTest {

    @Mock
    AgreementDocumentsServices agreementDocumentsServices;

    @Mock
    PreparedPersonServices preparedPersonServices;

    @Mock
    SignedPersonServices signedPersonServices;

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

        mockMvc.perform(get("/documents/agreementDocuments/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("agreement/agreementDocumentList"))
                .andExpect(model().attribute("listDocuments", hasSize(2)));
    }
    
    @Test
    void showDocument() throws Exception {
        when(agreementDocumentsServices.findById(anyLong())).thenReturn(AgreementDocuments.builder().id(1L).build());
        
        mockMvc.perform(get("/documents/agreementDocuments/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("agreement/documentDetails"))
                .andExpect(model().attributeExists("document"));
    }

    @Test
    void initFindDocumentForm() throws Exception {

        mockMvc.perform(get("/documents/agreementDocuments/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("agreement/findDocument"))
                .andExpect(model().attributeExists("document"));
    }

    @Test
    void processFindDocumentFormReturnOne() throws Exception {
        when(agreementDocumentsServices.findByContractorLike(anyString())).thenReturn(Arrays.asList(AgreementDocuments.builder().id(1L).build()));

        mockMvc.perform(get("/documents/agreementDocuments"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/documents/agreementDocuments/1/show"));
    }

    @Test
    void processFindDocumentFormReturnMany() throws Exception {
        when(agreementDocumentsServices.findByContractorLike(anyString()))
                .thenReturn(Arrays.asList(AgreementDocuments.builder().id(1L).build(),
                        AgreementDocuments.builder().id(2L).build()));

        mockMvc.perform(get("/documents/agreementDocuments"))
                .andExpect(status().isOk())
                .andExpect(view().name("agreement/agreementDocumentList"))
                .andExpect(model().attribute("listDocuments", hasSize(2)));
    }

    @Test
    void initCreationDocumentForm() throws Exception {
        Set<PreparedPerson> preparedPersonSet = new HashSet<>();
        preparedPersonSet.add(PreparedPerson.builder().id(1L).build());
        preparedPersonSet.add(PreparedPerson.builder().id(2L).build());

        Set<SignedPerson> signedPerson = new HashSet<>();
        signedPerson.add(SignedPerson.builder().id(1L).build());
        signedPerson.add(SignedPerson.builder().id(2L).build());

        when(signedPersonServices.findAll()).thenReturn(signedPerson);
        when(preparedPersonServices.findAll()).thenReturn(preparedPersonSet);

        mockMvc.perform(get("/documents/agreementDocuments/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("agreement/createOrUpdateDocument"))
                .andExpect(model().attributeExists("document"))
                .andExpect(model().attribute("listPreparedPerson", hasSize(2)))
                .andExpect(model().attribute("listSignedPerson", hasSize(2)));

        verify(signedPersonServices).findAll();
        verify(preparedPersonServices).findAll();
    }

    @Test
    void processCreationDocumentForm() throws Exception {
        when(agreementDocumentsServices.save(any())).thenReturn(AgreementDocuments.builder().id(1L).build());

        mockMvc.perform(post("/documents/agreementDocuments/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/documents/agreementDocuments/1/show"));

        verify(agreementDocumentsServices).save(any());

    }

    @Test
    void initUpdateDocumentForm() throws Exception {
        Set<PreparedPerson> preparedPersonSet = new HashSet<>();
        preparedPersonSet.add(PreparedPerson.builder().id(1L).build());
        preparedPersonSet.add(PreparedPerson.builder().id(2L).build());

        Set<SignedPerson> signedPerson = new HashSet<>();
        signedPerson.add(SignedPerson.builder().id(1L).build());
        signedPerson.add(SignedPerson.builder().id(2L).build());

        when(signedPersonServices.findAll()).thenReturn(signedPerson);
        when(preparedPersonServices.findAll()).thenReturn(preparedPersonSet);
        when(agreementDocumentsServices.findById(anyLong())).thenReturn(AgreementDocuments.builder().id(1L).build());

        mockMvc.perform(get("/documents/agreementDocuments/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("agreement/createOrUpdateDocument"))
                .andExpect(model().attributeExists("document"))
                .andExpect(model().attribute("listPreparedPerson", hasSize(2)))
                .andExpect(model().attribute("listSignedPerson", hasSize(2)));

        verify(agreementDocumentsServices).findById(anyLong());
        verify(preparedPersonServices).findAll();
        verify(signedPersonServices).findAll();

    }

    @Test
    void processUpdateDocumentForm() throws Exception {
        when(agreementDocumentsServices.save(any())).thenReturn(AgreementDocuments.builder().id(1L).build());

        mockMvc.perform(post("/documents/agreementDocuments/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/documents/agreementDocuments/1/show"));

        ArgumentCaptor<AgreementDocuments> argument = ArgumentCaptor.forClass(AgreementDocuments.class);

        verify(agreementDocumentsServices).save(argument.capture());
        assertEquals(1, argument.getValue().getId());

    }

    @Test
    void deleteDocument() throws Exception {

        mockMvc.perform(get("/documents/agreementDocuments/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/documents/agreementDocuments/list"));

        verify(agreementDocumentsServices).deleteById(anyLong());
    }
}