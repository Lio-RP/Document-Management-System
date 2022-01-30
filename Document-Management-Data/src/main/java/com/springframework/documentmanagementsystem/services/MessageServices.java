package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.Message;

public interface MessageServices extends CrudServices<Message, Long>{

    Message findBySubject(String subject);

    Message findBySender(String sender);

    Message findByReceiver(String receiver);
}
