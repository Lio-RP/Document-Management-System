package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.Message;
import com.springframework.documentmanagementsystem.repositories.PostsRepository;
import com.springframework.documentmanagementsystem.services.MessageServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
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
    public List<Message> findBySubjectLike(String subject) {
        return postsRepository.findBySubjectLike(subject);
    }

    @Override
    public Message findBySender(String sender) {
        return postsRepository.findBySender(sender).orElse(null);
    }
}
