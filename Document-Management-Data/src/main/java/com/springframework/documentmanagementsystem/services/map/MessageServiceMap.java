package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.Message;
import com.springframework.documentmanagementsystem.services.MessageServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    public List<Message> findBySubjectLike(String subject) {
        Set<Message> foundPosts = new HashSet<>();
;
        for(Message post : this.findAll()){
            if(post.getSubject().equalsIgnoreCase(subject)){
                foundPosts.add(post);
            }
        }
        List<Message> posts = new ArrayList<>(foundPosts);
        return posts;
    }

    @Override
    public Message findBySender(String sender) {
        boolean sendBy;
        Set<Message> posts = this.findAll();
        for(Message post : posts){
            sendBy = post.getSender().equalsIgnoreCase(sender);
            if(sendBy){
                return post;
            }
        }
        return null;
    }
}
