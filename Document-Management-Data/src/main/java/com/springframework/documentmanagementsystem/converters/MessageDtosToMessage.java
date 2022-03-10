package com.springframework.documentmanagementsystem.converters;

import com.springframework.documentmanagementsystem.dtos.MessageDtos;
import com.springframework.documentmanagementsystem.models.Message;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MessageDtosToMessage implements Converter<MessageDtos, Message> {

    @Override
    public Message convert(MessageDtos source) {

        Message message = new Message();
        message.setId(source.getId());
        message.setSubject(source.getSubject());
        message.setSender(source.getReceiver());
        message.setReceiver(source.getReceiver());
        message.setMessage(source.getMessage());

        return message;
    }
}
