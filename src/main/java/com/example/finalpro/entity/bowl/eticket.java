package com.example.finalpro.entity.bowl;

import javax.persistence.Entity;

@Entity
public class eticket {
    private Integer orderid;

    private String companyname;
    private String flightname;
    private String takeofflocation;
    private String landinglocation;
    private String departuretime;
    private String landingtime;
    private String departuregate;
    private Integer terminal;
    private String realname;
    private String seatinfo;
    private String tickettype;

    public eticket(Integer orderid,String companyname,String flightname,String takeofflocation,String landinglocation,String departuretime,String landingtime,String departuregate,Integer terminal,String realname, String seatinfo,String tickettype){
        this.orderid = orderid;
        this.companyname = companyname;
        this.flightname = flightname;
        this.takeofflocation = takeofflocation;
        this.landinglocation = landinglocation;
        this.departuretime = departuretime;
        this.landingtime = landingtime;
        this.departuregate = departuregate;
        this.terminal = terminal;
        this.realname = realname;
        this.seatinfo = seatinfo;
        this.tickettype = tickettype;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public String getDeparturegate() {
        return departuregate;
    }

    public void setDeparturegate(String departuregate) {
        this.departuregate = departuregate;
    }

    public String getLandingtime() {
        return landingtime;
    }

    public void setLandingtime(String landingtime) {
        this.landingtime = landingtime;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getLandinglocation() {
        return landinglocation;
    }

    public void setLandinglocation(String landinglocation) {
        this.landinglocation = landinglocation;
    }

    public String getTakeofflocation() {
        return takeofflocation;
    }

    public void setTakeofflocation(String takeofflocation) {
        this.takeofflocation = takeofflocation;
    }

    public String getSeatinfo() {
        return seatinfo;
    }

    public void setSeatinfo(String seatinfo) {
        this.seatinfo = seatinfo;
    }

    public String getFlightname() {
        return flightname;
    }

    public void setFlightname(String flightname) {
        this.flightname = flightname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getTickettype() {
        return tickettype;
    }

    public void setTickettype(String tickettype) {
        this.tickettype = tickettype;
    }
}
