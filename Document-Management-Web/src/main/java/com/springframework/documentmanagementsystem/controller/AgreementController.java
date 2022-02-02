package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("agreement")
@Controller
public class AgreementController {

    private final AgreementDocumentsServices agreementDocumentsServices;

    public AgreementController(AgreementDocumentsServices agreementDocumentsServices) {
        this.agreementDocumentsServices = agreementDocumentsServices;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getDocuments(Model model){
        model.addAttribute("listDocuments", agreementDocumentsServices.findAll());
        return "agreement/index";
    }
}
