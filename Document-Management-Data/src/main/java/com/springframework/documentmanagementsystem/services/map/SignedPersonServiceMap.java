package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "mapservices"})
public class SignedPersonServiceMap extends AbstractServiceMap<SignedPerson, Long> implements SignedPersonServices {

    @Override
    public SignedPerson save(SignedPerson object) {
        return super.save(object);
    }

    @Override
    public SignedPerson findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<SignedPerson> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(SignedPerson object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public SignedPerson findByLastName(String lastName) {
        return null;
    }
}
