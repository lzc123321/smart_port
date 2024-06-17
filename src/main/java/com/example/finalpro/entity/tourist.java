package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class tourist {
    @Id
    private Integer touristid;

    private String email;
    private String passwords;
    private String salt;
    private String vip;

    public tourist(Integer touristid,String email,String passwords,String salt,String vip){
        this.touristid = touristid;
        this.email = email;
        this.vip = vip;
        this.passwords = passwords;
        this.salt = salt;
    }

    public Integer getTouristid(){
        return touristid;
    }

    public void setTouristid(Integer touristid){
        this.touristid = touristid;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getVip(){
        return this.vip;
    }

    public void setVip(String vip){
        this.vip = vip;
    }

    public String getPasswords(){
        return passwords;
    }

    public void setPasswords(String passwords){
        this.passwords = passwords;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
