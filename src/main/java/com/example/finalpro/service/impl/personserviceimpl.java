package com.example.finalpro.service.impl;

import com.example.finalpro.entity.person;
import com.example.finalpro.mapper.personmapper;
import com.example.finalpro.service.personservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personservice")
public class personserviceimpl implements personservice {
    @Autowired
    private personmapper personMapper;

    public person getPersonByCombine(Integer touristid, String idnumber,Integer exceptid){return personMapper.getPersonByCombine(touristid,idnumber,exceptid);}
    public person getPersonByID(Integer personid){return personMapper.getPersonByID(personid);}
    public void updateOldPerson(person newperson){personMapper.updateOldPerson(newperson);}
    public void removeOldPerson(Integer personid){personMapper.removeOldPerson(personid);}
    public void addNewPerson(person newperson){personMapper.addNewPerson(newperson);}
    public List<person> listPersonByTouristid(Integer touristid){return personMapper.listPersonByTouristid(touristid);}
}
