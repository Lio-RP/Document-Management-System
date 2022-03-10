package com.springframework.documentmanagementsystem.converters;

import com.springframework.documentmanagementsystem.dtos.MessageDtos;
import com.springframework.documentmanagementsystem.models.Message;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MessageToMessageDtos implements Converter<Message, MessageDtos> {

    @Override
    public MessageDtos convert(Message source) {

        MessageDtos dtos = new MessageDtos();
        dtos.setId(source.getId());
        dtos.setSubject(source.getSubject());
        dtos.setSender(source.getSender());
        dtos.setReceiver(source.getReceiver());
        dtos.setMessage(source.getMessage());

        return dtos;
    }
}
