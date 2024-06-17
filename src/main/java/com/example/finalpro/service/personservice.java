package com.example.finalpro.service;

import com.example.finalpro.entity.person;

import java.util.List;

public interface personservice {
    public person getPersonByCombine(Integer touristid, String idnumber,Integer exceptid);
    public person getPersonByID(Integer personid);
    public void updateOldPerson(person newperson);
    public void removeOldPerson(Integer personid);
    public void addNewPerson(person newperson);
    public List<person> listPersonByTouristid(Integer touristid);
}
