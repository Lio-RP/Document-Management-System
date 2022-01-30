package com.springframework.documentmanagementsystem.services;

import com.springframework.documentmanagementsystem.models.Prepared;

public interface PreparedServices extends CrudServices<Prepared, Long> {

    Prepared findByLastName(String lastName);
}
