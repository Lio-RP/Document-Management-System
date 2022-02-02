package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.ExecutedPerson;
import com.springframework.documentmanagementsystem.services.ExecutedPersonServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExecutedPersonServiceMap extends AbstractServiceMap<ExecutedPerson, Long> implements ExecutedPersonServices {

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

    @Override
    public ExecutedPerson findByLastName(String lastName) {
        return null;
    }
}
