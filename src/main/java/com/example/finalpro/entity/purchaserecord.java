package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class purchaserecord {
    @Id
    private Integer orderid;

    private Integer personid;
    private Integer ticketid;
    private String purchasetime;
    private String seatinfo;

    public purchaserecord(Integer orderid,Integer personid,Integer ticketid,String purchasetime,String seatinfo){
        this.orderid = orderid;
        this.personid = personid;
        this.ticketid = ticketid;
        this.purchasetime = purchasetime;
        this.seatinfo = seatinfo;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public Integer getTicketid() {
        return ticketid;
    }

    public void setTicketid(Integer ticketid) {
        this.ticketid = ticketid;
    }

    public String getPurchasetime() {
        return purchasetime;
    }

    public void setPurchasetime(String purchasetime) {
        this.purchasetime = purchasetime;
    }

    public String getSeatinfo() {
        return seatinfo;
    }

    public void setSeatinfo(String seatinfo) {
        this.seatinfo = seatinfo;
    }
}
