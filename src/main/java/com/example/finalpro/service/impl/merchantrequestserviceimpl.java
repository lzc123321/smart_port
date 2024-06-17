package com.example.finalpro.service.impl;

import com.example.finalpro.mapper.merchantrequestmapper;
import com.example.finalpro.entity.merchantrequest;
import com.example.finalpro.service.merchantrequestservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("merchantrequestservice")
public class merchantrequestserviceimpl implements merchantrequestservice{
    @Autowired
    private merchantrequestmapper merchantrequestMapper;

    public void addNewMerchantrequest(merchantrequest newrequest){merchantrequestMapper.addNewMerchantrequest(newrequest);}
    public merchantrequest getMerchantrequestByEmail(String email){return merchantrequestMapper.getMerchantrequestByEmail(email);}
    public merchantrequest getMerchantrequestByID(Integer requestid){return merchantrequestMapper.getMerchantrequestByID(requestid);}
    public merchantrequest getMerchantrequestByIdnumber(String idnumber){return merchantrequestMapper.getMerchantrequestByIdnumber(idnumber);}
    public void removeOldMerchantrequest(Integer requestid){merchantrequestMapper.removeOldMerchantrequest(requestid);}
    public List<merchantrequest> listAllRequest(){return merchantrequestMapper.listAllRequest();}
}
