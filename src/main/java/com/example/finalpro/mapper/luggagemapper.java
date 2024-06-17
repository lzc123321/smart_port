package com.example.finalpro.mapper;

import com.example.finalpro.entity.luggage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface luggagemapper {
    public void addNewLuggage(luggage newluggage);
    public void updateOldLuggage(@Param("luggageid") Integer luggageid,@Param("state") String state,@Param("location") String location);
    public luggage getLuggageByID(Integer luggageid);
    public luggage getLuggageByCombine(@Param("personid") Integer personid,@Param("ticketid") Integer ticketid);
    public void removeOldLuggage(Integer luggageid);
}
