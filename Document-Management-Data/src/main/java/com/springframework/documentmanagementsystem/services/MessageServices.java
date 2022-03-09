package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.Message;

import java.util.List;

public interface MessageServices extends CrudServices<Message, Long>{

    List<Message> findBySubjectLike(String subject);

    Message findBySender(String sender);
}
