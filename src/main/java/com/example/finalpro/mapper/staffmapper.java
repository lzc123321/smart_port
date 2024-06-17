package com.example.finalpro.mapper;

import com.example.finalpro.entity.staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface staffmapper {
    public void logupNewStaff(staff newstaff);
    public void removeOldStaff(Integer staffid);
    public void updateOldStaff(staff newstaff);
    public void updatePassword(@Param("staffid") Integer staffid, @Param("newpasswords") String newpasswords);
    public staff getStaffByEmail(@Param("email") String email,@Param("exceptid") Integer exceptid);
    public staff getStaffByIdnumber(@Param("idnumber") String  idnumber,@Param("exceptid") Integer exceptid);
    public staff getStaffByID(Integer staffid);
}