package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.Message;
import com.springframework.documentmanagementsystem.repositories.PostsRepository;
import com.springframework.documentmanagementsystem.services.MessageServices;

import java.util.HashSet;
import java.util.Set;

public class MessageSDJpaService implements MessageServices {

    private final PostsRepository postsRepository;

    public MessageSDJpaService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public Message save(Message object) {
        return postsRepository.save(object);
    }

    @Override
    public Message findById(Long aLong) {
        return postsRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Message> findAll() {
        Set<Message> messages = new HashSet<>();
        postsRepository.findAll().forEach(messages::add);
        return messages;
    }

    @Override
    public void delete(Message object) {
        postsRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        postsRepository.deleteById(aLong);
    }

    @Override
    public Message findBySubject(String subject) {
        return postsRepository.findBySubject(subject).orElse(null);
    }

    @Override
    public Message findBySender(String sender) {
        return postsRepository.findBySender(sender).orElse(null);
    }

    @Override
    public Message findByReceiver(String receiver) {
        return postsRepository.findByReceiver(receiver).orElse(null);
    }
}