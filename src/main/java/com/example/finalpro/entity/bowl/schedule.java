package com.example.finalpro.entity.bowl;

import javax.persistence.Entity;

@Entity
public class schedule {
    private String companyname;
    private String flightname;
    private String takeofflocation;
    private String landinglocation;
    private String departuretime;
    private String landingtime;
    private String departuregate;
    private Integer terminal;
    private String status;

    public schedule(String companyname,String flightname,String takeofflocation,String landinglocation,String departuretime,String landingtime,String departuregate,Integer terminal,String status){
        this.companyname = companyname;
        this.departuregate = departuregate;
        this.flightname = flightname;
        this.landingtime = landingtime;
        this.departuretime = departuretime;
        this.takeofflocation = takeofflocation;
        this.landinglocation = landinglocation;
        this.terminal = terminal;
        this.status = status;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getFlightname() {
        return flightname;
    }

    public void setFlightname(String flightname) {
        this.flightname = flightname;
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

    public String getTakeofflocation() {
        return takeofflocation;
    }

    public void setTakeofflocation(String takeofflocation) {
        this.takeofflocation = takeofflocation;
    }

    public String getLandinglocation() {
        return landinglocation;
    }

    public void setLandinglocation(String landinglocation) {
        this.landinglocation = landinglocation;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getLandingtime() {
        return landingtime;
    }

    public void setLandingtime(String landingtime) {
        this.landingtime = landingtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
