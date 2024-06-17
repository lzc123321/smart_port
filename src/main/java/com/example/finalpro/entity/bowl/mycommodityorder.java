package com.example.finalpro.entity.bowl;

import javax.persistence.Entity;

@Entity
public class mycommodityorder {
    private Integer orderid;
    private String shopname;
    private String commodityname;
    private Integer counts;
    private Integer terminal;
    private String departuregate;
    private String arrivetime;
    private Double price;
    private String merchantemail;
    private String touristemail;

    public mycommodityorder(Integer orderid,String shopname,String commodityname, Integer counts,Integer terminal, String departuregate,String arrivetime, Double price,String merchantemail,String touristemail){
        this.orderid = orderid;
        this.shopname = shopname;
        this.commodityname = commodityname;
        this.counts = counts;
        this.terminal = terminal;
        this.departuregate = departuregate;
        this.arrivetime = arrivetime;
        this.price = price;
        this.merchantemail = merchantemail;
        this.touristemail = touristemail;
    }

    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMerchantemail() {
        return merchantemail;
    }

    public void setMerchantemail(String merchantemail) {
        this.merchantemail = merchantemail;
    }

    public String getTouristemail() {
        return touristemail;
    }

    public void setTouristemail(String touristemail) {
        this.touristemail = touristemail;
    }
}
