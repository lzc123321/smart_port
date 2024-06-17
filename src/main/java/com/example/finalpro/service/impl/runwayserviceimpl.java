package com.example.finalpro.service.impl;

import com.example.finalpro.entity.runway;
import com.example.finalpro.mapper.runwaymapper;
import com.example.finalpro.service.runwayservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("runwayservice")
public class runwayserviceimpl implements runwayservice {
    @Autowired
    private runwaymapper runwayMapper;

    public List<runway> listOccupyByRunway(Integer runway,String thatday,Integer exceptid){return runwayMapper.listOccupyByRunway(runway,thatday,exceptid);}
    public void addNewOccupy(runway newrunway){runwayMapper.addNewOccupy(newrunway);}
    public void updateOldOccupy(runway newrunway){runwayMapper.updateOldOccupy(newrunway);}
}
