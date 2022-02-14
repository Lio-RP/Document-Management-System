package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostsRepository extends CrudRepository<Message, Long> {

    Optional<Message> findBySubject(String subject);

    Optional<Message> findBySender(String sender);

    Optional<Message> findByReceiver(String receiver);
}
