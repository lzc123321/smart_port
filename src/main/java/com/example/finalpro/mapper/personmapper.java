package com.example.finalpro.mapper;

import com.example.finalpro.entity.person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface personmapper {
    public person getPersonByCombine(@Param("touristid") Integer touristid, @Param("idnumber") String idnumber,@Param("exceptid") Integer exceptid);
    public person getPersonByID(Integer personid);
    public void updateOldPerson(person newperson);
    public void removeOldPerson(Integer personid);
    public void addNewPerson(person newperson);
    public List<person> listPersonByTouristid(Integer touristid);
}
