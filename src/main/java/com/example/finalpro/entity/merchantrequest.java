package com.example.finalpro.entity;

import javax.persistence.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class merchantrequest {
    @Id
    private Integer requestid;

    private String realname;
    private String passwords;
    private String salt;
    private String shopname;
    private String email;
    private String idnumber;

    public merchantrequest(Integer requestid, String realname,String passwords,String salt,String shopname,String email,String idnumber){
        this.requestid = requestid;
        this.realname = realname;
        this.salt = salt;
        this.passwords = passwords;
        this.shopname = shopname;
        this.email = email;
        this.idnumber = idnumber;
    }

    public Integer getRequestid() {
        return requestid;
    }

    public void setRequestid(Integer requestid) {
        this.requestid = requestid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
