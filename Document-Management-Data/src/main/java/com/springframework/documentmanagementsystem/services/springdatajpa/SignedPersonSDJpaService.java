package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.repositories.SignedPersonRepository;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SignedPersonSDJpaService implements SignedPersonServices {

    private final SignedPersonRepository signedPersonRepository;

    public SignedPersonSDJpaService(SignedPersonRepository signedPersonRepository) {
        this.signedPersonRepository = signedPersonRepository;
    }

    @Override
    public SignedPerson save(SignedPerson object) {
        return signedPersonRepository.save(object);
    }

    @Override
    public SignedPerson findById(Long aLong) {
        return signedPersonRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<SignedPerson> findAll() {
        Set<SignedPerson> signedPersonSet = new HashSet<>();
        signedPersonRepository.findAll().forEach(signedPersonSet::add);
        return signedPersonSet;
    }

    @Override
    public void delete(SignedPerson object) {
        signedPersonRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        signedPersonRepository.deleteById(aLong);
    }

    @Override
    public SignedPerson findByLastName(String lastName) {
        return signedPersonRepository.findByLastName(lastName).orElse(null);
    }
}
