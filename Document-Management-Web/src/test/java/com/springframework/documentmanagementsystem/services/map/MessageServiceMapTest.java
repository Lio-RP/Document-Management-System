package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MessageServiceMapTest {

    public static final String SUBJECT = "Activation License";
    public static final String SENDER = "Liban Abdullahi";
    MessageServiceMap posts;

    Set<Message> messageSet;

    @BeforeEach
    void setUp() {
        posts = new MessageServiceMap();

        posts.save(Message.builder().id(1L).subject(SUBJECT).sender(SENDER).build());
    }

    @Test
    void save() {
        Message message = Message.builder().id(2L).build();

        Message savedPost = posts.save(message);

        assertNotNull(savedPost);
    }

    @Test
    void findById() {
        Message message = posts.findById(1L);

        assertEquals(1, message.getId());
    }

    @Test
    void findAll() {
        Set<Message> messages = posts.findAll();

        assertEquals(1, messages.size());
    }

    @Test
    void delete() {
        posts.delete(posts.findById(1L));

        assertEquals(0, posts.findAll().size());
    }

    @Test
    void deleteById() {
        posts.deleteById(1L);

        assertEquals(0, posts.findAll().size());
    }

    @Test
    void findBySubject() {

        List<Message> foundedPostBySub = posts.findBySubjectLike("activation license");

        assertEquals("Activation License", foundedPostBySub.iterator().next().getSubject());
    }

    @Test
    void findBySender() {
        Message foundedPostBySender = posts.findBySender("liban abdullahi");

        assertEquals("Liban Abdullahi", foundedPostBySender.getSender());
    }
}