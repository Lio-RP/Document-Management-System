package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "mapservices"})
public class ServiceDocumentsServiceMap extends AbstractServiceMap<ServiceDocuments, Long> implements ServiceDocumentsServices {

    private final SignedPersonServices signedPersonServices;
    private final PreparedPersonServices preparedPersonServices;

    public ServiceDocumentsServiceMap(SignedPersonServices signedPersonServices,
                                      PreparedPersonServices preparedPersonServices) {
        this.signedPersonServices = signedPersonServices;
        this.preparedPersonServices = preparedPersonServices;
    }

    @Override
    public ServiceDocuments save(ServiceDocuments object) {
        if(object != null){
            if(object.getSignedPerson() != null && object.getPreparedPerson() != null){
                if(object.getSignedPerson().getId() == null |
                        object.getPreparedPerson().getId() == null){
                    object.setSignedPerson(signedPersonServices.save(object.getSignedPerson()));
                    object.setPreparedPerson(preparedPersonServices.save(object.getPreparedPerson()));
                }
            }else{
                throw new RuntimeException("Singed Person Or Prepared User Can Not Be Null!.");
            }
            return super.save(object);
        }else{
            throw new RuntimeException("Service Document Not Found!.");
        }

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

    @Override
    public ServiceDocuments findByRegistrationNumber(int registrationNumber) {
        //TO DO.....
        return null;
    }
}
