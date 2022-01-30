package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.ExecutedPerson;
import com.springframework.documentmanagementsystem.services.CrudServices;

import java.util.Set;

public class ExecutedPersonServiceMap extends AbstractServiceMap<ExecutedPerson, Long> implements CrudServices<ExecutedPerson, Long> {

    @Override
    public ExecutedPerson save(ExecutedPerson executor) {
        return super.save(executor.getId(), executor);
    }

    @Override
    public ExecutedPerson findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<ExecutedPerson> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(ExecutedPerson executor) {
        super.delete(executor);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
