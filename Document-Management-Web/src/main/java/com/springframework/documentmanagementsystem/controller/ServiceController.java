package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.ServiceDocuments;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import com.springframework.documentmanagementsystem.services.ServiceDocumentsServices;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RequestMapping("/documents/serviceDocuments")
@Controller
public class ServiceController {

    public static final String SERVICE_CREATE_OR_UPDATE_DOCUMENT_FORM = "service/createOrUpdateDocument";
    private final ServiceDocumentsServices serviceDocumentsServices;
    private final PreparedPersonServices preparedPersonServices;
    private final SignedPersonServices signedPersonServices;

    public ServiceController(ServiceDocumentsServices serviceDocumentsServices, PreparedPersonServices preparedPersonServices, SignedPersonServices signedPersonServices) {
        this.serviceDocumentsServices = serviceDocumentsServices;
        this.preparedPersonServices = preparedPersonServices;
        this.signedPersonServices = signedPersonServices;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }


    @ModelAttribute("listPreparedPerson")
    public Set<PreparedPerson> listPreparedPerson(){
        return preparedPersonServices.findAll();
    }

    @ModelAttribute("listSignedPerson")
    public Set<SignedPerson> listSignedPerson(){
        return signedPersonServices.findAll();
    }

    @RequestMapping("/list")
    public String getDocuments(Model model){
        model.addAttribute("listDocuments", serviceDocumentsServices.findAll());
        return "service/serviceDocumentList";
    }

    @GetMapping("/{id}/show")
    public String showDocument(@PathVariable("id") Long id, Model model){
        model.addAttribute("document", serviceDocumentsServices.findById(id));
        return "service/documentDetails";
    }

    @GetMapping("/find")
    public String initFindForm(Model model){
        model.addAttribute("document", ServiceDocuments.builder().build());
        return "service/findDocument";
    }

    @GetMapping
    public String processFindDocumentForm(ServiceDocuments serviceDoc, BindingResult result){

        ServiceDocuments docResults = serviceDocumentsServices.findByRegistrationNumber(serviceDoc.getRegistrationNumber());
        return "redirect:/documents/serviceDocuments/" + docResults.getId() + "/show";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        ServiceDocuments serviceDoc = ServiceDocuments.builder().build();

        //init working users:
        serviceDoc.setPreparedPerson(new PreparedPerson());
        serviceDoc.setSignedPerson(new SignedPerson());

        //add to the model
        model.addAttribute("document", serviceDoc);
        return SERVICE_CREATE_OR_UPDATE_DOCUMENT_FORM;
    }

    @PostMapping("/new")
    public String processCreationDocumentForm(@Valid @ModelAttribute("document") ServiceDocuments serviceDoc,
                                              BindingResult result, Model model){
        if(result.hasErrors()){
            return SERVICE_CREATE_OR_UPDATE_DOCUMENT_FORM;
        }else{
            ServiceDocuments savedDoc = serviceDocumentsServices.save(serviceDoc);
            return "redirect:/documents/serviceDocuments/" + savedDoc.getId() + "/show";
        }
    }

    @GetMapping("/{id}/edit")
    public String initUpdateDocumentForm(@PathVariable Long id, Model model){
        ServiceDocuments foundedDoc = serviceDocumentsServices.findById(id);
        model.addAttribute("document", foundedDoc);
        return SERVICE_CREATE_OR_UPDATE_DOCUMENT_FORM;
    }

    @PostMapping("/{id}/edit")
    public String processUpdateDocumentForm(@Valid @ModelAttribute("document") ServiceDocuments serviceDoc,
                                            BindingResult result,
                                            Model model,
                                            @PathVariable Long id){
        if(result.hasErrors()){
            return SERVICE_CREATE_OR_UPDATE_DOCUMENT_FORM;
        }else{
            serviceDoc.setId(id);
            ServiceDocuments savedDoc = serviceDocumentsServices.save(serviceDoc);
            return "redirect:/documents/serviceDocuments/" + savedDoc.getId() + "/show";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteDocument(@PathVariable Long id){
        serviceDocumentsServices.deleteById(id);
        return "redirect:/documents/serviceDocuments/list";
    }
}
