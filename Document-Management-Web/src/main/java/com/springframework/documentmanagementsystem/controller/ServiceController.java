package com.springframework.documentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("service")
@Controller
public class ServiceController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getService(Model model){
        return "service/index";
    }
}
