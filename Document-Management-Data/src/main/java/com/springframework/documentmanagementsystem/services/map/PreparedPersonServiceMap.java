package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PreparedPersonServiceMap extends AbstractServiceMap<PreparedPerson, Long> implements PreparedPersonServices {

    @Override
    public PreparedPerson save(PreparedPerson prepared) {
        return super.save(prepared);
    }

    @Override
    public PreparedPerson findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<PreparedPerson> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PreparedPerson prepared) {
        super.delete(prepared);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PreparedPerson findByLastName(String lastName) {
        return null;
    }
}
