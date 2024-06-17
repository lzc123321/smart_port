package com.example.finalpro.mapper;

import com.example.finalpro.entity.tourist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface touristmapper {
    public void logupNewTourist(tourist newtourist);
    public void updatePassword(@Param("touristid") Integer touristid,@Param("newpasswords") String newpasswords);
    public void updateEmail(@Param("touristid") Integer touristid,@Param("newemail") String newemail);
    public tourist getTouristByEmail(String email);
    public tourist getTouristByID(Integer touristid);
}
