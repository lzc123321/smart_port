package com.example.finalpro.service.impl;

import com.example.finalpro.entity.purchaserecord;
import com.example.finalpro.mapper.purchaserecordmapper;
import com.example.finalpro.service.purchaserecordservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purchaserecordservice")
public class purchaserecordserviceimpl implements purchaserecordservice {
    @Autowired
    private purchaserecordmapper purchaserecordMapper;

    @Override
    public void addNewRecord(purchaserecord newrecord){purchaserecordMapper.addNewRecord(newrecord);}
    public void removeOldRecord(Integer orderid){purchaserecordMapper.removeOldRecord(orderid);}
    public void selectSeatForOrderid(Integer orderid,String seatinfo){purchaserecordMapper.selectSeatForOrderid(orderid,seatinfo);}
    public purchaserecord getRecordByID(Integer orderid){return purchaserecordMapper.getRecordByID(orderid);}
    public purchaserecord getRecordByCombine(Integer ticketid,String seatinfo){return purchaserecordMapper.getRecordByCombine(ticketid,seatinfo);}
    public List<purchaserecord> listAllRecord(){return purchaserecordMapper.listAllRecord();}
    public List<purchaserecord> getRecordByTicketid(Integer ticketid){return purchaserecordMapper.getRecordByTicketid(ticketid);}
    public List<purchaserecord> listTodayRecord(String today){return purchaserecordMapper.listTodayRecord(today);}
    public Integer getCountByTicketid(Integer ticketid){return purchaserecordMapper.getCountByTicketid(ticketid);}
}
