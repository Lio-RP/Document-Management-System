package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class DocsJsonController {

    private final AgreementDocumentsServices agreementDocumentsServices;
    private final ServiceDocumentsServices serviceDocumentsServices;

    public DocsJsonController(AgreementDocumentsServices agreementDocumentsServices, ServiceDocumentsServices serviceDocumentsServices) {
        this.agreementDocumentsServices = agreementDocumentsServices;
        this.serviceDocumentsServices = serviceDocumentsServices;
    }

    @GetMapping("/api/docs/agreementDocs")
    public @ResponseBody
    Set<AgreementDocuments> listAgreementDocsAsJson(){
        return agreementDocumentsServices.findAll();
    }

    @GetMapping("/api/docs/serviceDocs")
    public @ResponseBody Set<ServiceDocuments> listServiceDocsAsJson(){
        return serviceDocumentsServices.findAll();
    }
}
