package com.example.finalpro.mapper;

import com.example.finalpro.entity.airlinecompany;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface companymapper {
    public void logupNewCompany(airlinecompany newcompany);
    public void updateOldCompany(airlinecompany newcompany);
    public void updatePassword(@Param("touristid") Integer companyid, @Param("newpasswords") String newpasswords);
    public airlinecompany getCompanyByEmail(@Param("email") String email,@Param("exceptid") Integer exceptid);
    public airlinecompany getCompanyByID(Integer companyid);
}
