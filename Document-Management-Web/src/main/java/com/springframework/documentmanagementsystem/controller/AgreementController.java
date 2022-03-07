package com.springframework.documentmanagementsystem.controller;

import com.springframework.documentmanagementsystem.models.AgreementDocuments;
import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.services.AgreementDocumentsServices;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Slf4j
@RequestMapping("/documents/agreementDocuments")
@Controller
public class AgreementController {

    private final AgreementDocumentsServices agreementDocumentsServices;
    private final PreparedPersonServices preparedPersonServices;
    private final SignedPersonServices signedPersonServices;

    public AgreementController(AgreementDocumentsServices agreementDocumentsServices, PreparedPersonServices preparedPersonServices, SignedPersonServices signedPersonServices) {
        this.agreementDocumentsServices = agreementDocumentsServices;
        this.preparedPersonServices = preparedPersonServices;
        this.signedPersonServices = signedPersonServices;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("listPreparedPerson")
    public Set<PreparedPerson> findAllPreparedUsers(){
        return preparedPersonServices.findAll();
    }

    @ModelAttribute("listSignedPerson")
    public Set<SignedPerson> findAllSignedUsers(){
        return signedPersonServices.findAll();
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

    @GetMapping("/new")
    public String initCreationDocumentForm(Model model){
        model.addAttribute("document", AgreementDocuments.builder().build());
        return "agreement/createOrUpdateDocument";
    }

    @PostMapping("/new")
    public String processCreationDocumentForm(@Valid AgreementDocuments agreementDoc, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("document", AgreementDocuments.builder().build());
            return "agreement/createOrUpdateDocument";
        }else{
            log.debug("in the process to save...............................");
            AgreementDocuments savedDoc = agreementDocumentsServices.save(agreementDoc);
            return "redirect:/documents/agreementDocuments/" + savedDoc.getId() + "/show";
        }
    }

    @GetMapping("/{id}/edit")
    public String initUpdateDocumentForm(@PathVariable Long id, Model model){
        model.addAttribute("document", agreementDocumentsServices.findById(id));
        return "agreement/createOrUpdateDocument";
    }

    @PostMapping("/{id}/edit")
    public String processUpdateDocumentForm(@Valid AgreementDocuments agreementDoc,
                                            BindingResult result, Model model,
                                            @PathVariable Long id){
        if(result.hasErrors()){
            model.addAttribute("document", agreementDocumentsServices.findById(id));
            return "agreement/createOrUpdateDocument";
        }else{
            agreementDoc.setId(id);
            AgreementDocuments savedDoc = agreementDocumentsServices.save(agreementDoc);
            return "redirect:/documents/agreementDocuments/" + savedDoc.getId() + "/show";
        }

    }
}
