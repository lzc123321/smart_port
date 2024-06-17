package com.example.finalpro.service;

import com.example.finalpro.entity.repairrecord;

import java.util.List;

public interface repairrecordservice {
    public void addNewRepairrecord(repairrecord newrepairrecord);
    public repairrecord getRepairrecordByID(Integer recordid);
    public void examineRepairrecord(Integer recordid,Integer approved);
    public void removeOldRepairrecord(Integer recordid);
    public List<repairrecord> listAllRecord();
}