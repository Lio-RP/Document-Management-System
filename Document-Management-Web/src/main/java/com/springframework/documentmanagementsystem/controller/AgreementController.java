package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/documents/agreementDocuments")
@Controller
public class AgreementController {

    private final AgreementDocumentsServices agreementDocumentsServices;

    public AgreementController(AgreementDocumentsServices agreementDocumentsServices) {
        this.agreementDocumentsServices = agreementDocumentsServices;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/list")
    public String getDocuments(Model model){
        model.addAttribute("listDocuments", agreementDocumentsServices.findAll());
        return "agreement/agreementDocumentList";
    }

    @GetMapping("/{id}/show")
    public String showDocument(@PathVariable Long id, Model model){
        model.addAttribute("document", agreementDocumentsServices.findById(id));
        return "agreement/documentDetails";
    }

    @GetMapping("/find")
    public String initFindDocumentForm(Model model){
        model.addAttribute("document", AgreementDocuments.builder().build());
        return "agreement/findDocument";
    }

    @GetMapping
    public String processFindDocumentForm(AgreementDocuments agreementDocuments, BindingResult result, Model model){

        //Allow parameterless get /documents/agreementDocuments to return all agreement documents
        if(agreementDocuments.getContractor() == null){
            agreementDocuments.setContractor("");
        }

        //find document by contractor name
        String contractor = agreementDocuments.getContractor();
        List<AgreementDocuments> documentResults = agreementDocumentsServices.findByContractorLike("%" + contractor + "%");

        if(documentResults.isEmpty()){

            //Not found document;
            result.rejectValue("contractor", "notFound", "Not Found");
            return "agreement/findDocument";
        }else if(documentResults.size() == 1){

            //Found one document
            agreementDocuments = documentResults.get(0);
            return "redirect:/documents/agreementDocuments/" + agreementDocuments.getId() + "/show";
        }else{

            //Found more than one document
            model.addAttribute("listDocuments", documentResults);
            return "agreement/agreementDocumentList";
        }
    }
}
