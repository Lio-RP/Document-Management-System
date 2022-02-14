package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.repositories.PreparedPersonRepository;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PreparedPersonSDJpaService implements PreparedPersonServices {

    private final PreparedPersonRepository preparedPersonRepository;

    public PreparedPersonSDJpaService(PreparedPersonRepository preparedPersonRepository) {
        this.preparedPersonRepository = preparedPersonRepository;
    }

    @Override
    public PreparedPerson save(PreparedPerson object) {
        return preparedPersonRepository.save(object);
    }

    @Override
    public PreparedPerson findById(Long aLong) {
        return preparedPersonRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<PreparedPerson> findAll() {
        Set<PreparedPerson> preparedPersonSet = new HashSet<>();
        preparedPersonRepository.findAll().forEach(preparedPersonSet::add);
        return preparedPersonSet;
    }

    @Override
    public void delete(PreparedPerson object) {
        preparedPersonRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        preparedPersonRepository.deleteById(aLong);
    }

    @Override
    public PreparedPerson findByLastName(String lastName) {
        return preparedPersonRepository.findByLastName(lastName).orElse(null);
    }
}
