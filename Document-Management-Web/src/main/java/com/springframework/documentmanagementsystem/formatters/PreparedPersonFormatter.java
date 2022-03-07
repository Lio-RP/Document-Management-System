package com.springframework.documentmanagementsystem.formatters;

import com.springframework.documentmanagementsystem.models.PreparedPerson;
import com.springframework.documentmanagementsystem.services.PreparedPersonServices;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Set;

@Component
public class PreparedPersonFormatter implements Formatter<PreparedPerson> {

    private final PreparedPersonServices preparedPersonServices;

    public PreparedPersonFormatter(PreparedPersonServices preparedPersonServices) {
        this.preparedPersonServices = preparedPersonServices;
    }

    @Override
    public String print(PreparedPerson object, Locale locale) {
        return object.getFirstName() + ' ' + object.getLastName();
    }

    @Override
    public PreparedPerson parse(String text, Locale locale) throws ParseException {
        Set<PreparedPerson> users = preparedPersonServices.findAll();
        for(PreparedPerson preparedPerson : users){
            String name = preparedPerson.getFirstName() + ' ' + preparedPerson.getLastName();
            if(name.equals(text)){
                return preparedPerson;
            }
        }
        throw new ParseException("PreparedPerson Not Found" + text, 0);
    }
}
