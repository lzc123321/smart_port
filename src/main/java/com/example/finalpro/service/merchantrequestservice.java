package com.example.finalpro.service;

import com.example.finalpro.entity.merchantrequest;

import java.util.List;

public interface merchantrequestservice {
    public void addNewMerchantrequest(merchantrequest newrequest);
    public merchantrequest getMerchantrequestByEmail(String email);
    public merchantrequest getMerchantrequestByID(Integer requestid);
    public merchantrequest getMerchantrequestByIdnumber(String idnumber);
    public void removeOldMerchantrequest(Integer requestid);
    public List<merchantrequest> listAllRequest();
}