package com.springframework.documentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("agreement")
@Controller
public class AgreementController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getDocuments(Model model){
        return "agreement/index";
    }
}
