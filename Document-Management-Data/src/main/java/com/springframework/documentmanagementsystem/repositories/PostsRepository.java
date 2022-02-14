package com.springframework.documentmanagementsystem.repositories;

import com.springframework.documentmanagementsystem.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Message, Long> {
}
