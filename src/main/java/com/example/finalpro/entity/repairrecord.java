package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class repairrecord {
    @Id
    private Integer recordid;

    private String deviceinfo;
    private String devicename;
    private String devicepicture;
    private String location;
    private Integer approved;

    public repairrecord(Integer recordid,String devicename,String devicepicture,String deviceinfo,String location,Integer approved){
        this.recordid = recordid;
        this.devicename = devicename;
        this.devicepicture = devicepicture;
        this.deviceinfo = deviceinfo;
        this.location = location;
        this.approved = approved;
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public String getDeviceinfo() {
        return deviceinfo;
    }

    public void setDeviceinfo(String deviceinfo) {
        this.deviceinfo = deviceinfo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDevicepicture() {
        return devicepicture;
    }

    public void setDevicepicture(String devicepicture) {
        this.devicepicture = devicepicture;
    }
}
