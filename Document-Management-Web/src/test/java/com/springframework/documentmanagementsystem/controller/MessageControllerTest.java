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

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
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
}