package com.example.finalpro.mapper;

import com.example.finalpro.entity.merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface merchantmapper {
    public void logupNewMerchant(merchant newmerchant);
    public merchant getMerchantByID(Integer merchantid);
    public merchant getMerchantByEmail(@Param("email") String email,@Param("exceptid") Integer exceptid);
    public merchant getMerchantByIdnumber(@Param("idnumber") String idnumber,@Param("exceptid") Integer exceptid);
    public List<merchant> listAllMerchant();
    public void updateOldMerchant(merchant newmerchant);
    public void updatePassword(@Param("merchantid") Integer merchantid, @Param("newpasswords") String newpasswords);
    public void removeOldMerchant(Integer merchantid);
}
