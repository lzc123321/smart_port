package com.example.finalpro.service.impl;

import com.example.finalpro.mapper.touristmapper;
import com.example.finalpro.entity.tourist;
import com.example.finalpro.service.touristservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("touristservice")
public class touristserviceimpl implements touristservice{
    @Autowired
    private touristmapper touristMapper;

    public void logupNewTourist(tourist newtourist){touristMapper.logupNewTourist(newtourist);}
    public void updatePassword(Integer touristid, String newpasswords){touristMapper.updatePassword(touristid,newpasswords);}
    public void updateEmail(Integer touristid,String newemail){touristMapper.updateEmail(touristid,newemail);}
    public tourist getTouristByEmail(String email){return touristMapper.getTouristByEmail(email);}
    public tourist getTouristByID(Integer touristid){return touristMapper.getTouristByID(touristid);}
}
