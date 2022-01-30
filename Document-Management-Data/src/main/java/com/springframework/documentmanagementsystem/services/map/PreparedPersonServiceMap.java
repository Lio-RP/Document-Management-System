package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.services.CrudServices;

import java.util.Set;

public class PreparedPersonServiceMap extends AbstractServiceMap<PreparedPerson, Long> implements CrudServices<PreparedPerson, Long> {

    @Override
    public PreparedPerson save(PreparedPerson prepared) {
        return super.save(prepared.getId(), prepared);
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
}
