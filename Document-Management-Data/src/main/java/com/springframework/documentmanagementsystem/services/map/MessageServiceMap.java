package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.Message;
import com.springframework.documentmanagementsystem.services.CrudServices;

import java.util.Set;

public class MessageServiceMap extends AbstractServiceMap<Message, Long> implements CrudServices<Message, Long> {

    @Override
    public Message save(Message message) {
        return super.save(message.getId(), message);
    }

    @Override
    public Message findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Message> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Message message) {
        super.delete(message);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
