package com.example.finalpro.service;

import com.example.finalpro.entity.flight;

import java.util.List;

public interface flightservice {
    public flight getFlightByID(Integer flightid);
    public flight getFlightByCombine(String name,Integer companyid,String departuretime,Integer exceptid);
    public void addNewFlight(flight newflight);
    public void updateOldFlight(flight newflight);
    public void removeOldFlight(Integer flightid);
    public List<flight> listFlightByCompanyid(Integer companyid);
    public List<flight> listTodayFlight(String today);
    public List<flight> listFlightByCombine(String takeofflocation,String landinglocation,String date);
}
