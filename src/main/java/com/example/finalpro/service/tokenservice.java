package com.example.finalpro.service;

import com.example.finalpro.entity.token;

public interface tokenservice {
    public void loginNewToken(token newtoken,int type);
    public void updateOldToken(token newtoken,int type);
    public token getTokenByID(Integer id,int type);
    public token getTokenByToken(String token,int type);
    public void logoutOldToken(String token,int type);
}
