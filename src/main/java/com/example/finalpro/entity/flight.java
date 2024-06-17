package com.example.finalpro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "航班实体类")
public class flight {
    @Id
    @TableId(type = IdType.AUTO, value = "航班id")
    @ApiModelProperty(value = "航班id")
    private Integer flightid;

    @ApiModelProperty(value = "航班名称")
    private String name;

    @ApiModelProperty(value = "航空公司id")
    private Integer companyid;

    @ApiModelProperty(value = "起飞地点")
    private String takeofflocation;

    @ApiModelProperty(value = "降落地点")
    private String landinglocation;

    @ApiModelProperty(value = "起飞时间")
    private String departuretime;

    @ApiModelProperty(value = "降落时间")
    private String landingtime;

    @ApiModelProperty(value = "起降机场")
    private String departuregate;

    @ApiModelProperty(value = "航站楼")
    private Integer terminal;

    public flight(Integer flightid,String name,Integer companyid,String takeofflocation,String landinglocation,String departuretime,String landingtime,String departuregate,Integer terminal){
        this.flightid = flightid;
        this.name = name;
        this.companyid = companyid;
        this.takeofflocation = takeofflocation;
        this.landinglocation = landinglocation;
        this.departuretime = departuretime;
        this.landingtime = landingtime;
        this.departuregate = departuregate;
        this.terminal = terminal;
    }

    public Integer getFlightid() {
        return flightid;
    }

    public void setFlightid(Integer flightid) {
        this.flightid = flightid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getTakeofflocation() {
        return takeofflocation;
    }

    public void setTakeofflocation(String takeofflocation) {
        this.takeofflocation = takeofflocation;
    }

    public String getLandinglocation() {
        return landinglocation;
    }

    public void setLandinglocation(String landinglocation) {
        this.landinglocation = landinglocation;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getLandingtime() {
        return landingtime;
    }

    public void setLandingtime(String landingtime) {
        this.landingtime = landingtime;
    }

    public String getDeparturegate() {
        return departuregate;
    }

    public void setDeparturegate(String departuregate) {
        this.departuregate = departuregate;
    }

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }
}
