package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class parkingorder {
    @Id
    private Integer orderid;

    private Integer touristid;
    private String starttime;
    private String endtime;
    private Integer parkingspaceid;

    public parkingorder(Integer orderid,Integer touristid,String starttime,String endtime,Integer parkingspaceid){
        this.orderid = orderid;
        this.touristid = touristid;
        this.starttime = starttime;
        this.endtime = endtime;
        this.parkingspaceid = parkingspaceid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getTouristid() {
        return touristid;
    }

    public void setTouristid(Integer touristid) {
        this.touristid = touristid;
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

    public Integer getParkingspaceid() {
        return parkingspaceid;
    }

    public void setParkingspaceid(Integer parkingspaceid) {
        this.parkingspaceid = parkingspaceid;
    }
}
