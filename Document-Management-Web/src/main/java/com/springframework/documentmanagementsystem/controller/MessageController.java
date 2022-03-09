package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.services.MessageServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/posts")
@Controller
public class MessageController {

    private final MessageServices messageServices;

    public MessageController(MessageServices messageServices) {
        this.messageServices = messageServices;
    }

    @GetMapping("/listPosts")
    public String getMessages(Model model){
        model.addAttribute("listPosts", messageServices.findAll());
        return "messages/posts";
    }
}
