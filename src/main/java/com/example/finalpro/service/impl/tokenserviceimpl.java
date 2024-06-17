package com.example.finalpro.service.impl;

import com.example.finalpro.mapper.tokenmapper;
import com.example.finalpro.entity.token;
import com.example.finalpro.service.tokenservice;
import com.example.finalpro.config.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tokenservice")
public class tokenserviceimpl implements tokenservice {
    @Autowired
    private tokenmapper tokenMapper;

    public void loginNewToken(token newtoken,int type){
        switch (type){
            case TypeUtil.Token.TOURIST:
                tokenMapper.loginNewToken_TOURIST(newtoken);
                break;
            case TypeUtil.Token.MERCHANT:
                tokenMapper.loginNewToken_MERCHANT(newtoken);
                break;
            case TypeUtil.Token.STAFF:
                tokenMapper.loginNewToken_STAFF(newtoken);
                break;
            case TypeUtil.Token.COMPANY:
                tokenMapper.loginNewToken_COMPANY(newtoken);
                break;
            default:
                break;
        }
    }
    public void updateOldToken(token newtoken,int type){
        switch (type){
            case TypeUtil.Token.TOURIST:
                tokenMapper.updateOldToken_TOURIST(newtoken);
                break;
            case TypeUtil.Token.MERCHANT:
                tokenMapper.updateOldToken_MERCHANT(newtoken);
                break;
            case TypeUtil.Token.STAFF:
                tokenMapper.updateOldToken_STAFF(newtoken);
                break;
            case TypeUtil.Token.COMPANY:
                tokenMapper.updateOldToken_COMPANY(newtoken);
                break;
            default:
                break;
        }
    }
    public token getTokenByID(Integer id,int type){
        token rttoken = null;
        switch (type){
            case TypeUtil.Token.TOURIST:
                rttoken = tokenMapper.getTokenByID_TOURIST(id);
                break;
            case TypeUtil.Token.MERCHANT:
                rttoken = tokenMapper.getTokenByID_MERCHANT(id);
                break;
            case TypeUtil.Token.STAFF:
                rttoken = tokenMapper.getTokenByID_STAFF(id);
                break;
            case TypeUtil.Token.COMPANY:
                rttoken = tokenMapper.getTokenByID_COMPANY(id);
                break;
            default:
                break;
        }
        return rttoken;
    }

    public token getTokenByToken(String token,int type){
        token rttoken = null;
        switch (type){
            case TypeUtil.Token.TOURIST:
                rttoken = tokenMapper.getTokenByToken_TOURIST(token);
                break;
            case TypeUtil.Token.MERCHANT:
                rttoken = tokenMapper.getTokenByToken_MERCHANT(token);
                break;
            case TypeUtil.Token.STAFF:
                rttoken = tokenMapper.getTokenByToken_STAFF(token);
                break;
            case TypeUtil.Token.COMPANY:
                rttoken = tokenMapper.getTokenByToken_COMPANY(token);
                break;
            default:
                break;
        }
        return rttoken;
    }

    public void logoutOldToken(String token,int type){

        switch (type){
            case TypeUtil.Token.TOURIST:
                tokenMapper.logoutOldToken_TOURIST(token);
                break;
            case TypeUtil.Token.MERCHANT:
                tokenMapper.logoutOldToken_MERCHANT(token);
                break;
            case TypeUtil.Token.STAFF:
                tokenMapper.logoutOldToken_STAFF(token);
                break;
            case TypeUtil.Token.COMPANY:
                tokenMapper.logoutOldToken_COMPANY(token);
                break;
            default:
                break;
        }
    }
}
