package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.converters.MessageDtosToMessage;
import com.springframework.documentmanagementsystem.converters.MessageToMessageDtos;
import com.springframework.documentmanagementsystem.models.Message;
import com.springframework.documentmanagementsystem.repositories.PostsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageSDJpaServiceTest {


    @Mock
    PostsRepository postsRepository;

    @InjectMocks
    MessageSDJpaService postJpaService;

    @Mock
    MessageDtosToMessage convertToMessage;

    @Mock
    MessageToMessageDtos convertToMessageDtos;


    Set<Message> messages;

    @BeforeEach
    void setUp(){
        messages = new HashSet<>();
        messages.add(Message.builder().id(1L).build());
        messages.add(Message.builder().id(2L).build());

    }

    @Test
    void save(){
        Message message = Message.builder().id(3L).build();

        when(postsRepository.save(any())).thenReturn(message);

        Message savedPost = postJpaService.save(message);

        assertNotNull(savedPost);
        assertEquals(3L, savedPost.getId());
        verify(postsRepository, times(1)).save(any());
    }

    @Test
    void findAll(){
        when(postsRepository.findAll()).thenReturn(messages);

        Set<Message> docs = postJpaService.findAll();

        assertEquals(2, docs.size());

    }

    @Test
    void findById(){
       Message post = Message.builder().id(1L).build();

        when(postsRepository.findById(1L)).thenReturn(Optional.of(post));

        Message foundedDocById = postJpaService.findById(1L);

        assertEquals(1L, foundedDocById.getId());

    }

    @Test
    void delete(){

        Message message = Message.builder().build();

        postJpaService.delete(message);

        verify(postsRepository).delete(any());

        //assertNull();

    }

    @Test
    void deleteById(){

        Message message = Message.builder().id(1L).build();

        postJpaService.deleteById(message.getId());

        verify(postsRepository, times(1)).deleteById(anyLong());

    }

    @Test
    void findBySubject(){
        
        when(postsRepository.findBySubjectLike(any()))
                .thenReturn(Arrays.asList(Message.builder().id(1L).subject("Activation License").build(),
                Message.builder().id(2L).subject("Activation License").build()));

        List<Message> foundedPostBySub = postJpaService.findBySubjectLike("Activation License");

        assertEquals("Activation License", foundedPostBySub.iterator().next().getSubject());
        assertEquals(2, foundedPostBySub.size());
        verify(postsRepository, times(1)).findBySubjectLike(any());
    }

    @Test
    void findBySender(){
        Message message = Message.builder().id(1L).sender("Liban Abdullahi").build();

        when(postsRepository.findBySender(any())).thenReturn(Optional.of(message));

        Message foundedPostBySender = postJpaService.findBySender("Liban Abdullahi");

        assertEquals("Liban Abdullahi", foundedPostBySender.getSender());
        verify(postsRepository, times(1)).findBySender(any());
    }
}
