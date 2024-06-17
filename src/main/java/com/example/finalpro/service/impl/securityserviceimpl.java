package com.example.finalpro.service.impl;

import com.example.finalpro.mapper.securitymapper;
import com.example.finalpro.service.securityservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("securityservice")
public class securityserviceimpl implements securityservice {
    @Autowired
    private securitymapper securityMapper;

    public String SHA1(String code){return securityMapper.SHA1(code);}
    public String MD5(String code){return securityMapper.MD5(code);}
}
