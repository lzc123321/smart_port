package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class parkingspace {
    @Id
    private Integer parkingspaceid;

    private String location;
    private Double price;

    public parkingspace(Integer parkingspaceid,String location,Double price){
        this.parkingspaceid = parkingspaceid;
        this.location = location;
        this.price = price;
    }

    public Integer getParkingspaceid() {
        return parkingspaceid;
    }

    public void setParkingspaceid(Integer parkingspaceid) {
        this.parkingspaceid = parkingspaceid;
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
}
