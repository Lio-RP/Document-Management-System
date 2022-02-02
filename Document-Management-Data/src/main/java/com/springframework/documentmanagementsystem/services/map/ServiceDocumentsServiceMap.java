package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceDocumentsServiceMap extends AbstractServiceMap<ServiceDocuments, Long> implements ServiceDocumentsServices {

    @Override
    public ServiceDocuments save(ServiceDocuments serviceDocuments) {
        return super.save(serviceDocuments);
    }

    @Override
    public ServiceDocuments findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<ServiceDocuments> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(ServiceDocuments serviceDocuments) {
        super.delete(serviceDocuments);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
