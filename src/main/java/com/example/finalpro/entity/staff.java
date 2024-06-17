package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class staff {
    @Id
    private Integer staffid;

    private String realname;
    private Integer positionpost;
    private String email;
    private String passwords;
    private String salt;
    private String idnumber;

    public staff(Integer staffid,String realname, Integer positionpost,String email,String passwords,String salt,String idnumber){
        this.staffid = staffid;
        this.realname = realname;
        this.positionpost = positionpost;
        this.email = email;
        this.passwords = passwords;
        this.salt = salt;
        this.idnumber = idnumber;
    }

    public Integer getStaffid(){
        return this.staffid;
    }

    public void setStaffid(Integer staffid){
        this.staffid = staffid;
    }

    public String getRealname(){
        return this.realname;
    }

    public void setRealname(String realname){
        this.realname = realname;
    }

    public Integer getPositionpost(){
        return this.positionpost;
    }

    public void setPositionpost(Integer positionpost){
        this.positionpost = positionpost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
}
