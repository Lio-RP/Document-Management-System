package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.Message;
import com.springframework.documentmanagementsystem.services.MessageServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "mapservices"})
public class MessageServiceMap extends AbstractServiceMap<Message, Long> implements MessageServices {

    @Override
    public Message save(Message message) {
        return super.save(message);
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

    @Override
    public Message findBySubject(String subject) {
        return null;
    }

    @Override
    public Message findBySender(String sender) {
        return null;
    }

    @Override
    public Message findByReceiver(String receiver) {
        return null;
    }
}
