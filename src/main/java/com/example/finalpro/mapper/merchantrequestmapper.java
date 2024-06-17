package com.example.finalpro.mapper;

import com.example.finalpro.entity.merchantrequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface merchantrequestmapper {
    public void addNewMerchantrequest(merchantrequest newrequest);
    public merchantrequest getMerchantrequestByEmail(String email);
    public merchantrequest getMerchantrequestByID(Integer requestid);
    public merchantrequest getMerchantrequestByIdnumber(String idnumber);
    public void removeOldMerchantrequest(Integer requestid);
    public List<merchantrequest> listAllRequest();
}
