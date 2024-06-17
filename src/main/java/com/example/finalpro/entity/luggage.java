package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "行李实体类")
public class luggage {
    @Id
    @TableId(type = IdType.AUTO,value = "行李id")
    @ApiModelProperty(value = "行李id")
    private Integer luggageid;

    @ApiModelProperty(value = "旅客id")
    private Integer personid;

    @ApiModelProperty(value = "航班id")
    private Integer ticketid;

    @ApiModelProperty(value = "行李状态")
    private String state;

    @ApiModelProperty(value = "行李位置")
    private String location;

    public luggage(Integer luggageid,Integer personid,Integer ticketid,String state,String location){
        this.luggageid = luggageid;
        this.personid = personid;
        this.ticketid = ticketid;
        this.state = state;
        this.location = location;
    }

    public Integer getLuggageid() {
        return luggageid;
    }

    public void setLuggageid(Integer luggageid) {
        this.luggageid = luggageid;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
