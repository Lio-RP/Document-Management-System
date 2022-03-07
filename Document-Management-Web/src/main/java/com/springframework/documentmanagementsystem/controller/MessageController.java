package com.springframework.documentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/posts")
@Controller
public class MessageController {

    @GetMapping("/listPosts")
    public String getMessages(){

        return "messages/index";
    }
}
