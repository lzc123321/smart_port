package com.example.finalpro.mapper;

import com.example.finalpro.entity.purchaserecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface purchaserecordmapper {
    public void addNewRecord(purchaserecord newrecord);
    public void removeOldRecord(Integer orderid);
    public void selectSeatForOrderid(@Param("orderid") Integer orderid,@Param("seatinfo") String seatinfo);
    public purchaserecord getRecordByID(Integer orderid);
    public purchaserecord getRecordByCombine(@Param("ticketid") Integer ticketid,@Param("seatinfo") String seatinfo);
    public List<purchaserecord> listAllRecord();
    public List<purchaserecord> getRecordByTicketid(Integer ticketid);
    public List<purchaserecord> listTodayRecord(String today);
    public Integer getCountByTicketid(Integer ticketid);
}
