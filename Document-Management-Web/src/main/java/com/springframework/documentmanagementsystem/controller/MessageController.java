package com.springframework.documentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("messages")
@Controller
public class MessageController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getMessages(){

        return "messages/index";
    }
}
