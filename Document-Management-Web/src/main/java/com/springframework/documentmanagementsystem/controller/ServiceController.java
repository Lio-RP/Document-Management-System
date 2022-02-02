package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("service")
@Controller
public class ServiceController {

    private final ServiceDocumentsServices serviceDocumentsServices;

    public ServiceController(ServiceDocumentsServices serviceDocumentsServices) {
        this.serviceDocumentsServices = serviceDocumentsServices;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getDocuments(Model model){
        model.addAttribute("listDocuments", serviceDocumentsServices.findAll());
        return "service/index";
    }
}
