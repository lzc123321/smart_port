package com.example.finalpro.mapper;

import com.example.finalpro.entity.bowl.eticket;
import com.example.finalpro.entity.ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ticketmapper {
    public ticket getTicketByID(Integer ticketid);
    public ticket getTicketByCombine(@Param("flightid") Integer flightid,@Param("tickettype") String tickettype,@Param("exceptid") Integer exceptid);
    public void addNewTicket(ticket newticket);
    public void updateOldTicket(ticket newticket);
    public void removeOldTicket(Integer ticketid);
    public List<ticket> listTicketByFlightid(Integer flightid);
    public List<eticket> listEticketByTouristid(Integer touristid);
}
