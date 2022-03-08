package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class ServiceControllerTest {

    @InjectMocks
    ServiceController controller;

    @Mock
    ServiceDocumentsServices serviceDocumentsServices;

    @Mock
    PreparedPersonServices preparedPersonServices;

    @Mock
    SignedPersonServices signedPersonServices;

    MockMvc mockMvc;

    Set<ServiceDocuments> serviceDocumentsSet;

    @BeforeEach
    void setUp() {

        serviceDocumentsSet = new HashSet<>();

        serviceDocumentsSet.add(ServiceDocuments.builder().id(1L)
                        .preparedPerson(PreparedPerson.builder().build())
                        .singedPerson(SignedPerson.builder().build())
                .build());

        serviceDocumentsSet.add(ServiceDocuments.builder().id(2L)
                .preparedPerson(PreparedPerson.builder().build())
                .singedPerson(SignedPerson.builder().build())
                .build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void getDocuments() throws Exception {

        when(serviceDocumentsServices.findAll()).thenReturn(serviceDocumentsSet);

        mockMvc.perform(get("/documents/serviceDocuments/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("service/serviceDocumentList"))
                .andExpect(model().attribute("listDocuments", hasSize(2)));
    }

    @Test
    void showDocument() throws Exception {
        when(serviceDocumentsServices.findById(anyLong()))
                .thenReturn(ServiceDocuments.builder().id(1L).build());

        mockMvc.perform(get("/documents/serviceDocuments/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("service/documentDetails"))
                .andExpect(model().attributeExists("document"));

        verify(serviceDocumentsServices).findById(anyLong());
    }

    @Test
    void initFindForm() throws Exception {

        mockMvc.perform(get("/documents/serviceDocuments/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("service/findDocument"))
                .andExpect(model().attributeExists("document"));
    }

    @Test
    void processFindDocumentForm() throws Exception {
        when(serviceDocumentsServices.findByRegistrationNumber(anyInt()))
                .thenReturn(ServiceDocuments.builder().id(1L).build());

        mockMvc.perform(get("/documents/serviceDocuments"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/documents/serviceDocuments/1/show"));
    }

    @Test
    void initCreationDocumentForm() throws Exception {
        Set<PreparedPerson> preparedUsers = new HashSet<>();
        preparedUsers.add(PreparedPerson.builder().id(1L).build());

        Set<SignedPerson> signedUsers = new HashSet<>();
        signedUsers.add(SignedPerson.builder().id(1L).build());

        when(preparedPersonServices.findAll()).thenReturn(preparedUsers);
        when(signedPersonServices.findAll()).thenReturn(signedUsers);

        mockMvc.perform(get("/documents/serviceDocuments/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("service/createOrUpdateDocument"))
                .andExpect(model().attributeExists("document"))
                .andExpect(model().attribute("listPreparedPerson", hasSize(1)))
                .andExpect(model().attribute("listSignedPerson", hasSize(1)));

        verify(preparedPersonServices).findAll();
        verify(signedPersonServices).findAll();
    }

    @Test
    void processCreationDocumentForm() throws Exception {
        when(serviceDocumentsServices.save(any())).thenReturn(ServiceDocuments.builder().id(1L).build());

        mockMvc.perform(post("/documents/serviceDocuments/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/documents/serviceDocuments/1/show"));

        verify(serviceDocumentsServices).save(any());
    }

    @Test
    void initUpdateDocumentForm() throws Exception {
        Set<PreparedPerson> preparedUsers = new HashSet<>();
        preparedUsers.add(PreparedPerson.builder().id(1L).build());

        Set<SignedPerson> signedUsers = new HashSet<>();
        signedUsers.add(SignedPerson.builder().id(1L).build());

        when(preparedPersonServices.findAll()).thenReturn(preparedUsers);
        when(signedPersonServices.findAll()).thenReturn(signedUsers);
        when(serviceDocumentsServices.findById(anyLong())).thenReturn(ServiceDocuments.builder().id(1L).build());

        mockMvc.perform(get("/documents/serviceDocuments/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("service/createOrUpdateDocument"))
                .andExpect(model().attributeExists("document"))
                .andExpect(model().attribute("listPreparedPerson", hasSize(1)))
                .andExpect(model().attribute("listSignedPerson", hasSize(1)));

        verify(preparedPersonServices).findAll();
        verify(signedPersonServices).findAll();
        verify(serviceDocumentsServices).findById(anyLong());
    }

    @Test
    void processUpdateDocumentForm() throws Exception {
        when(serviceDocumentsServices.save(any())).thenReturn(ServiceDocuments.builder().id(1L).build());

        mockMvc.perform(post("/documents/serviceDocuments/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/documents/serviceDocuments/1/show"));

        verify(serviceDocumentsServices).save(any());
    }
}