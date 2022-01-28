package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.Message;

import java.util.Set;

public interface MessageServices {

    Message save(Message message);

    Message findBySubject(String subject);

    Message findBySender(String sender);

    Message findByReceiver(String receiver);

    Set<Message> findAll();
}
