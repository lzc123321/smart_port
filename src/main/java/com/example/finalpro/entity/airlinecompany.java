package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@ApiModel("航空公司实体类")
public class airlinecompany {

    @Id
    @Schema(defaultValue = "公司ID")
    private Integer companyid;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "公司名称")
    private String name;

    @Schema(description = "密码")
    private String passwords;

    @Schema(description = "加密值")
    private String salt;

    public airlinecompany(Integer companyid,String email,String name,String passwords,String salt){
        this.companyid = companyid;
        this.email = email;
        this.name = name;
        this.passwords = passwords;
        this.salt = salt;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
