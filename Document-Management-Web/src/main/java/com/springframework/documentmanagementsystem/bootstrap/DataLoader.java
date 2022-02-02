package com.springframework.documentmanagementsystem.bootstrap;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final AgreementDocumentsServices agreementDocumentsServices;
    private final ServiceDocumentsServices serviceDocumentsServices;

    public DataLoader(AgreementDocumentsServices agreementDocumentsServices, ServiceDocumentsServices serviceDocumentsServices) {
        this.agreementDocumentsServices = agreementDocumentsServices;
        this.serviceDocumentsServices = serviceDocumentsServices;
    }

    @Override
    public void run(String... args) throws Exception {

        AgreementDocuments agreementDocuments1 = new AgreementDocuments();
        agreementDocuments1.setId(1L);
        agreementDocuments1.setRegistrationNumber(101);
        agreementDocuments1.setRegistrationDate(LocalDate.now());
        agreementDocuments1.setTypeDocument("Agreement");
        agreementDocuments1.setStateDocument("Registering");
        agreementDocuments1.setTypeAgreement("Order Services");
        agreementDocuments1.setDeadlineAgreement(LocalDate.now());
        agreementDocuments1.setContractor("Hormuud Company");
        agreementDocuments1.setAmount((long) 234.5);
        agreementDocuments1.setPrepared("Liban Abdullahi");
        agreementDocuments1.setExecuted("Abdullahi Mohamed");
        agreementDocuments1.setNumberSheets(4);
        agreementDocuments1.setSummery("This is agreement document for ordering service Hormud Company");

        agreementDocumentsServices.save(agreementDocuments1);


        AgreementDocuments agreementDocuments2 = new AgreementDocuments();
        agreementDocuments2.setId(2L);
        agreementDocuments2.setRegistrationNumber(102);
        agreementDocuments2.setRegistrationDate(LocalDate.now());
        agreementDocuments2.setTypeDocument("Agreement");
        agreementDocuments2.setStateDocument("Registering");
        agreementDocuments2.setTypeAgreement("Order Services");
        agreementDocuments2.setDeadlineAgreement(LocalDate.now());
        agreementDocuments2.setContractor("Somtel Company");
        agreementDocuments2.setAmount((long) 23445.55);
        agreementDocuments2.setPrepared("Liban Abdullahi");
        agreementDocuments2.setExecuted("Abdullahi Mohamed");
        agreementDocuments2.setNumberSheets(4);
        agreementDocuments2.setSummery("This is agreement document for ordering service Hormud Company");

        agreementDocumentsServices.save(agreementDocuments2);

        System.out.println("Agreement Documents Loaded....");


        ServiceDocuments serviceDocuments1 = new ServiceDocuments();
        serviceDocuments1.setId(1L);
        serviceDocuments1.setRegistrationNumber(101);
        serviceDocuments1.setRegistrationDate(LocalDate.now());
        serviceDocuments1.setTypeDocument("Service");
        serviceDocuments1.setStateDocument("Registering");
        serviceDocuments1.setPrepared("Liban Abdullahi");
        serviceDocuments1.setExecuted("Abdullahi Mohamed");
        serviceDocuments1.setNumberSheets(4);
        serviceDocuments1.setSummery("This is service document for ordering service.");

        serviceDocumentsServices.save(serviceDocuments1);


        ServiceDocuments serviceDocuments2 = new ServiceDocuments();
        serviceDocuments2.setId(2L);
        serviceDocuments2.setRegistrationNumber(102);
        serviceDocuments2.setRegistrationDate(LocalDate.now());
        serviceDocuments2.setTypeDocument("Service");
        serviceDocuments2.setStateDocument("Executing");
        serviceDocuments2.setPrepared("Liban Abdullahi");
        serviceDocuments2.setExecuted("Abdullahi Mohamed");
        serviceDocuments2.setNumberSheets(3);
        serviceDocuments2.setSummery("This is service document for ordering service.");

        serviceDocumentsServices.save(serviceDocuments2);

        System.out.println("Service Documents Loaded.....");
    }
}
