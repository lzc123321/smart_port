package com.example.finalpro.entity.bowl;

import javax.persistence.Entity;

@Entity
public class myparkingorder {
    private Integer orderid;

    private String starttime;
    private String endtime;
    private String location;
    private Double price;
    private String status;

    public myparkingorder(Integer orderid,String starttime,String endtime,String location,Double price,String status){
        this.orderid = orderid;
        this.starttime = starttime;
        this.endtime = endtime;
        this.location = location;
        this.price = price;
        this.status = status;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
