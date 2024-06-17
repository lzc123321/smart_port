package com.example.finalpro.service.impl;

import com.example.finalpro.mapper.staffmapper;
import com.example.finalpro.entity.staff;
import com.example.finalpro.service.staffservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffservice")
public class staffserviceimpl implements staffservice{
    @Autowired
    private staffmapper staffMapper;

    public void logupNewStaff(staff newstaff){staffMapper.logupNewStaff(newstaff);}
    public void updateOldStaff(staff newstaff){staffMapper.updateOldStaff(newstaff);}
    public void updatePassword(Integer staffid, String newpasswords){staffMapper.updatePassword(staffid,newpasswords);}
    public void removeOldStaff(Integer staffid){staffMapper.removeOldStaff(staffid);}
    public staff getStaffByEmail(String email,Integer exceptid){return staffMapper.getStaffByEmail(email,exceptid);}
    public staff getStaffByIdnumber(String  idnumber,Integer exceptid){return staffMapper.getStaffByIdnumber(idnumber,exceptid);}
    public staff getStaffByID(Integer staffid){return staffMapper.getStaffByID(staffid);}
}
