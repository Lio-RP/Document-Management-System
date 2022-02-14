package com.springframework.documentmanagementsystem.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prepared_person")
public class PreparedPerson extends Employee{
}
