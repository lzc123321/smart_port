package com.example.finalpro.mapper;

import com.example.finalpro.entity.runway;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface runwaymapper {
    public List<runway> listOccupyByRunway(@Param("runway") Integer runway,@Param("thatday") String thatday,@Param("exceptid") Integer exceptid);
    public void addNewOccupy(runway newrunway);
    public void updateOldOccupy(runway newrunway);
}
