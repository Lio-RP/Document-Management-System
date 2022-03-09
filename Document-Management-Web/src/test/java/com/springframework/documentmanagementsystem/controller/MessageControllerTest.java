package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.Message;
import com.springframework.documentmanagementsystem.services.MessageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    @InjectMocks
    MessageController controller;

    @Mock
    MessageServices postService;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getMessages() throws Exception {
        Set<Message> posts = new HashSet<>();
        posts.add(Message.builder().id(1L).build());
        posts.add(Message.builder().id(2L).build());

        when(postService.findAll()).thenReturn(posts);

        mockMvc.perform(get("/posts/listPosts"))
                .andExpect(status().is(200))
                .andExpect(view().name("messages/posts"))
                .andExpect(model().attribute("listPosts", hasSize(2)));
    }

    @Test
    void showPost() throws Exception {
        when(postService.findById(anyLong())).thenReturn(Message.builder().id(1L).build());

        mockMvc.perform(get("/posts/1/show"))
                .andExpect(status().is(200))
                .andExpect(view().name("messages/postDetails"))
                .andExpect(model().attributeExists("post"));

        verify(postService).findById(anyLong());
    }

    @Test
    void initFindForm() throws Exception {

        mockMvc.perform(get("/posts/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("messages/findPost"))
                .andExpect(model().attributeExists("post"));
    }

    @Test
    void processFindPostFormReturningOne() throws Exception {
        when(postService.findBySubjectLike(anyString()))
                .thenReturn(Arrays.asList(Message.builder().id(1L).build()));

        mockMvc.perform(get("/posts"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/posts/1/show"));

        verify(postService).findBySubjectLike(anyString());
    }

    @Test
    void processFindPostFormReturningMany() throws Exception {
        when(postService.findBySubjectLike(anyString()))
                .thenReturn(Arrays.asList(Message.builder().id(1L).build(),
                        Message.builder().id(2L).build()));

        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(view().name("messages/posts"))
                .andExpect(model().attributeExists("listPosts"));

        verify(postService).findBySubjectLike(anyString());
    }
}