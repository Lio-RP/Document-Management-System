package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.Message;
import com.springframework.documentmanagementsystem.services.MessageServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/posts")
@Controller
public class MessageController {

    private final MessageServices messageServices;

    public MessageController(MessageServices messageServices) {
        this.messageServices = messageServices;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }

    @GetMapping("/listPosts")
    public String getMessages(Model model){
        model.addAttribute("listPosts", messageServices.findAll());
        return "messages/posts";
    }

    @GetMapping("/{id}/show")
    public String showPost(@PathVariable Long id, Model model){
        model.addAttribute("post", messageServices.findById(id));
        return "messages/postDetails";
    }

    @GetMapping("/find")
    public String initFindForm(Model model){
        model.addAttribute("post", Message.builder().build());
        return "messages/findPost";
    }

    @GetMapping
    public String processFindForm(Message message, Model model){

        //Let parameterless /posts to return all posts
        if(message.getSubject()==null){
            message.setSubject("");
        }

        //find the post
        String subject = message.getSubject();
        List<Message> postResult = messageServices.findBySubjectLike("%" + subject + "%");
        if(postResult.isEmpty()){
            model.addAttribute("post", Message.builder().build());
            return "messages/findPost";
        }else if(postResult.size()==1){

            //found one post:
            message = postResult.get(0);
            return "redirect:/posts/" + message.getId() + "/show";
        }else{

            //found more
            model.addAttribute("listPosts", postResult);
            return "messages/posts";
        }
    }
}
