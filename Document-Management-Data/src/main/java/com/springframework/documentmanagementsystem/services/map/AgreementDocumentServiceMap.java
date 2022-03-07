package com.springframework.documentmanagementsystem.services.map;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "mapservices"})
public class AgreementDocumentServiceMap extends AbstractServiceMap<AgreementDocuments, Long> implements AgreementDocumentsServices {

    private final PreparedPersonServices preparedPersonServices;
    private final SignedPersonServices signedPersonServices;

    public AgreementDocumentServiceMap(PreparedPersonServices preparedPersonServices,
                                       SignedPersonServices signedPersonServices) {
        this.preparedPersonServices = preparedPersonServices;
        this.signedPersonServices = signedPersonServices;
    }

    @Override
    public AgreementDocuments save(AgreementDocuments object) {
        if(object != null){
            if(object.getSignedPerson() != null && object.getPreparedPerson() != null){
                if(object.getSignedPerson().getId() == null |
                        object.getPreparedPerson().getId() == null){
                    object.setSignedPerson(signedPersonServices.save(object.getSignedPerson()));
                    object.setPreparedPerson(preparedPersonServices.save(object.getPreparedPerson()));
                }
            }else{
                throw new RuntimeException("Singed User or Prepared User Can Not be Null!.");
            }
            return super.save(object);
        }else{
            throw new RuntimeException("Agreement Document Not Found!.");
        }

    }

    @Override
    public AgreementDocuments findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<AgreementDocuments> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(AgreementDocuments agreementDocuments) {
        super.delete(agreementDocuments);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public List<AgreementDocuments> findByContractorLike(String contractor) {
        //TO DO....
        return null;
    }
}
