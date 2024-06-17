package com.example.finalpro.service;

import com.example.finalpro.entity.staff;

public interface staffservice {
    public void logupNewStaff(staff newstaff);
    public void updateOldStaff(staff newstaff);
    public void updatePassword(Integer staffid, String newpasswords);
    public void removeOldStaff(Integer staffid);
    public staff getStaffByEmail(String email,Integer exceptid);
    public staff getStaffByIdnumber(String  idnumber,Integer exceptid);
    public staff getStaffByID(Integer staffid);
}