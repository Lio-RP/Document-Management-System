package com.springframework.documentmanagementsystem.models;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Message extends BaseEntity{

    @Builder
    public Message(Long id, String sender, String receiver, String subject, String message) {
        super(id);
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.message = message;
    }

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;
}
