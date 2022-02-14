package com.springframework.documentmanagementsystem.services.springdatajpa;

import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.repositories.ServiceDocumentsRepository;
import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class ServiceDocumentsSDJpaService implements ServiceDocumentsServices {

    private final ServiceDocumentsRepository serviceDocumentsRepository;

    public ServiceDocumentsSDJpaService(ServiceDocumentsRepository serviceDocumentsRepository) {
        this.serviceDocumentsRepository = serviceDocumentsRepository;
    }

    @Override
    public ServiceDocuments save(ServiceDocuments object) {
        return serviceDocumentsRepository.save(object);
    }

    @Override
    public ServiceDocuments findById(Long aLong) {
        return serviceDocumentsRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<ServiceDocuments> findAll() {
        Set<ServiceDocuments> serviceDocuments = new HashSet<>();
        serviceDocumentsRepository.findAll().forEach(serviceDocuments::add);
        return serviceDocuments;
    }

    @Override
    public void delete(ServiceDocuments object) {
        serviceDocumentsRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        serviceDocumentsRepository.deleteById(aLong);
    }
}
