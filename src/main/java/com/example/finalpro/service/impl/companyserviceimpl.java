package com.example.finalpro.service.impl;

import com.example.finalpro.entity.airlinecompany;
import com.example.finalpro.mapper.companymapper;
import com.example.finalpro.service.companyservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("companyservice")
public class companyserviceimpl implements companyservice {
    @Autowired
    private companymapper companyMapper;

    public void logupNewCompany(airlinecompany newcompany){companyMapper.logupNewCompany(newcompany);}
    public void updateOldCompany(airlinecompany newcompany){companyMapper.updateOldCompany(newcompany);}
    public void updatePassword(Integer companyid,String newpasswords){companyMapper.updatePassword(companyid,newpasswords);}
    public airlinecompany getCompanyByEmail(String email,Integer exceptid){return companyMapper.getCompanyByEmail(email,exceptid);}
    public airlinecompany getCompanyByID(Integer companyid){return companyMapper.getCompanyByID(companyid);}
}
