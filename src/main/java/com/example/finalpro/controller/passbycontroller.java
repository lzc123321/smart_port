package com.example.finalpro.controller;



import com.example.finalpro.entity.bowl.schedule;
import com.example.finalpro.entity.flight;
import com.example.finalpro.service.flightservice;
import com.example.finalpro.service.impl.flightserviceimpl;
import com.example.finalpro.config.Inform;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/passby")
public class passbycontroller {
    @Resource
    private flightservice flightService = new flightserviceimpl();

    //游客查询航班信息功能
    @RequestMapping(value = "/searchflight",method = RequestMethod.POST)
    public Map<String,Object> searchFlight(@RequestParam Map<String,String> rawmap){
        Map<String,Object> map = new HashMap<>();

        //表单取参
        String takeofflocation = rawmap.get("takeofflocation");
        String landinglocation = rawmap.get("landinglocation");
        String date = rawmap.get("date");

        try {
            List<flight> rtlist = flightService.listFlightByCombine(takeofflocation,landinglocation,date+"%");
            map.put("success", true);
            map.put("message", rtlist);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "获取列表失败！");
        }
        return map;
    }

    //游客查询航班时刻表功能
    @RequestMapping(value = "/listschedule",method = RequestMethod.POST)
    public Map<String,Object> listSchedule(){
        Map<String,Object> map = new HashMap<>();

        try {
            List<schedule> rtlist = Inform.FlightSchedule;
            map.put("success", true);
            map.put("message", rtlist);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "获取列表失败！");
        }
        return map;
    }
}

