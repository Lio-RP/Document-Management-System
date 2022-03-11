package com.springframework.documentmanagementsystem.formatters;

import com.springframework.documentmanagementsystem.models.SignedPerson;
import com.springframework.documentmanagementsystem.services.SignedPersonServices;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Set;

@Component
public class SignedPersonFormatter implements Formatter<SignedPerson> {

    private final SignedPersonServices signedPersonServices;

    public SignedPersonFormatter(SignedPersonServices signedPersonServices) {
        this.signedPersonServices = signedPersonServices;
    }

    @Override
    public String print(SignedPerson object, Locale locale) {
        return object.getFirstName() + ' ' + object.getLastName();
    }

    @Override
    public SignedPerson parse(String text, Locale locale) throws ParseException {
        Set<SignedPerson> users = signedPersonServices.findAll();
        for(SignedPerson signedPerson : users){
            String name = signedPerson.getFirstName() + ' ' + signedPerson.getLastName();
            if(name.equals(text)){
                return signedPerson;
            }
        }
        throw new ParseException("Singed Person Not Found." + text, 0);
    }
}
