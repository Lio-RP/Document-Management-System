package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/documents/serviceDocuments")
@Controller
public class ServiceController {

    private final ServiceDocumentsServices serviceDocumentsServices;

    public ServiceController(ServiceDocumentsServices serviceDocumentsServices) {
        this.serviceDocumentsServices = serviceDocumentsServices;
    }

    @RequestMapping("/list")
    public String getDocuments(Model model){
        model.addAttribute("listDocuments", serviceDocumentsServices.findAll());
        return "service/serviceDocumentList";
    }

    @GetMapping("/{id}/show")
    public String showDocument(@PathVariable("id") Long id, Model model){
        model.addAttribute("document", serviceDocumentsServices.findById(id));
        return "service/documentDetails";
    }

    @GetMapping("/find")
    public String initFindForm(Model model){
        model.addAttribute("document", ServiceDocuments.builder().build());
        return "service/findDocument";
    }

    @GetMapping
    public String processFindDocumentForm(ServiceDocuments serviceDoc, BindingResult result){

        ServiceDocuments docResults = serviceDocumentsServices.findByRegistrationNumber(serviceDoc.getRegistrationNumber());
        return "redirect:/documents/serviceDocuments/" + docResults.getId() + "/show";
    }
}
