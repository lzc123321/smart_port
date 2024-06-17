package com.example.finalpro.mapper;

import com.example.finalpro.entity.flight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface flightmapper {
    public flight getFlightByID(Integer flightid);
    public flight getFlightByCombine(@Param("name") String name,@Param("companyid") Integer companyid,@Param("departuretime") String departuretime,@Param("exceptid") Integer exceptid);
    public void addNewFlight(flight newflight);
    public void updateOldFlight(flight newflight);
    public void removeOldFlight(Integer flightid);
    public List<flight> listFlightByCompanyid(Integer companyid);
    public List<flight> listTodayFlight(String today);
    public List<flight> listFlightByCombine(@Param("takeofflocation") String takeofflocation,@Param("landinglocation") String landinglocation,@Param("date") String date);
}
