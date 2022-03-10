package com.springframework.documentmanagementsystem.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDtos {

    private Long id;
    private String sender;
    private String receiver;
    private String subject;
    private String message;
}
