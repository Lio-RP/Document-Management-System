package com.springframework.documentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(){
        return "index";
    }

    @GetMapping("/documents")
    public String getDocumentsPage(){

        return "documentHome/displayDocuments";
    }

    @GetMapping("/documents/find")
    public String getFindDocumentsPage(){

        return "documentHome/findDocuments";
    }
}
