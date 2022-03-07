package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/documents")
@Controller
public class AgreementController {

    private final AgreementDocumentsServices agreementDocumentsServices;

    public AgreementController(AgreementDocumentsServices agreementDocumentsServices) {
        this.agreementDocumentsServices = agreementDocumentsServices;
    }

    @GetMapping("/agreementDocuments")
    public String getDocuments(Model model){
        model.addAttribute("listDocuments", agreementDocumentsServices.findAll());
        return "agreement/agreementDocumentList";
    }

    @GetMapping("/agreementDocument/{id}/show")
    public String showDocument(@PathVariable Long id, Model model){
        model.addAttribute("document", agreementDocumentsServices.findById(id));
        return "agreement/documentDetails";
    }
}
