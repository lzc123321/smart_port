package com.example.finalpro.mapper;

import com.example.finalpro.entity.token;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface tokenmapper {
    public void loginNewToken_TOURIST(token newtoken);
    public void loginNewToken_MERCHANT(token newtoken);
    public void loginNewToken_STAFF(token newtoken);
    public void loginNewToken_COMPANY(token newtoken);

    public void updateOldToken_TOURIST(token newtoken);
    public void updateOldToken_MERCHANT(token newtoken);
    public void updateOldToken_STAFF(token newtoken);
    public void updateOldToken_COMPANY(token newtoken);

    public token getTokenByID_TOURIST(Integer id);
    public token getTokenByID_MERCHANT(Integer id);
    public token getTokenByID_STAFF(Integer id);
    public token getTokenByID_COMPANY(Integer id);

    public token getTokenByToken_TOURIST(String token);
    public token getTokenByToken_MERCHANT(String token);
    public token getTokenByToken_STAFF(String token);
    public token getTokenByToken_COMPANY(String token);

    public void logoutOldToken_TOURIST(String token);
    public void logoutOldToken_MERCHANT(String token);
    public void logoutOldToken_STAFF(String token);
    public void logoutOldToken_COMPANY(String token);
}
