package com.example.finalpro.controller;



import com.example.finalpro.entity.*;
import com.example.finalpro.entity.bowl.*;
import com.example.finalpro.service.*;
import com.example.finalpro.service.impl.*;
import com.example.finalpro.config.EmailUtil;
import com.example.finalpro.config.TimeFormatUtil;
import com.example.finalpro.config.TypeUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/company")
public class companycontroller {
    @Resource
    private companyservice companyService = new companyserviceimpl();
    @Resource
    private tokenservice tokenService = new tokenserviceimpl();
    @Resource
    private securityservice securityService = new securityserviceimpl();
    @Resource
    private flightservice flightService = new flightserviceimpl();
    @Resource
    private ticketservice ticketService = new ticketserviceimpl();
    @Resource
    private runwayservice runwayService = new runwayserviceimpl();

    //航空公司注册功能
    @RequestMapping(value = "/logup", method = RequestMethod.POST)
    public Map<String, Object> logupCompany(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String email = rawmap.get("email");
        String name = rawmap.get("name");
        String passwords = rawmap.get("passwords");
        String repasswords = rawmap.get("repasswords");

        try {
            if (repasswords.equals(passwords)) {
                if(EmailUtil.isCorrect(email)) {
                    //对用户设置的密码加盐加密后保存
                    Random root = new Random((new Random()).nextInt());
                    String salt = root.nextInt() + "";
                    airlinecompany exist = companyService.getCompanyByEmail(email, 0);
                    if (exist != null) {
                        map.put("success", false);
                        map.put("message", "航司重复注册！");
                    } else {
                        companyService.logupNewCompany(new airlinecompany(0, email, name, passwords + salt, salt));
                        EmailUtil.sendInformationEmail(email,"尊敬的用户：您好！\n\t您的当前邮箱"+email+"已成功注册为"+TypeUtil.AirportLocation+"智慧机场系统航空公司！");
                        map.put("success", true);
                        map.put("message", "航司注册成功！");
                    }
                }else{
                    map.put("success", false);
                    map.put("message", "邮箱格式有误！");
                }
            } else {
                map.put("success", false);
                map.put("message", "确认密码不一致！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "航司注册失败！");
        }
        return map;
    }

    //航空公司登录功能
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> loginCompany(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();
        map.put("token", "null");

        //表单取参
        String email = rawmap.get("email");
        String passwords = rawmap.get("passwords");

        try {
            airlinecompany exist = companyService.getCompanyByEmail(email,0);
            if (exist != null) {
                //取出用户盐值，与当前输入的密码拼接加密后再与数据库中的信息进行比较
                String inpwd = securityService.SHA1(passwords + exist.getSalt());
                if (inpwd.equals(exist.getPasswords())) {
                    //将用户id经md5加密后作为token一并返回前端，便于后续访问
                    String companytk = securityService.MD5(exist.getCompanyid().toString());
                    token newtk = new token(exist.getCompanyid(), companytk);
                    token existtk = tokenService.getTokenByID(newtk.getId(), TypeUtil.Token.COMPANY);
                    if (existtk == null) {
                        tokenService.loginNewToken(newtk, TypeUtil.Token.COMPANY);
                    } else {
                        tokenService.updateOldToken(newtk, TypeUtil.Token.COMPANY);
                    }
                    map.put("success", true);
                    map.put("message", "航司登录成功！");
                    map.put("token", companytk);
                } else {
                    map.put("success", false);
                    map.put("message", "航司密码错误！");
                }
            } else {
                map.put("success", false);
                map.put("message", "航空公司不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "航司登录失败！");
        }
        return map;
    }

    //航空公司修改密码功能
    @RequestMapping(value = "/updatepassword",method = RequestMethod.POST)
    public Map<String,Object> updatePassword(@RequestParam Map<String,String> rawmap){
        Map<String,Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String newpasswords = rawmap.get("newpasswords");
        String renewpasswords = rawmap.get("renewpasswords");
        String passwords = rawmap.get("passwords");

        try{
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                if(renewpasswords.equals(newpasswords)) {
                    airlinecompany exist = companyService.getCompanyByID(tokenentity.getId());
                    String inpwd = securityService.SHA1(passwords+exist.getSalt());
                    if(inpwd.equals(exist.getPasswords())) {
                        companyService.updatePassword(tokenentity.getId(),newpasswords+exist.getSalt());
                        map.put("success", true);
                        map.put("message", "修改密码成功！");
                    }else{
                        map.put("success", false);
                        map.put("message", "航司密码错误！");
                    }
                }else{
                    map.put("success",false);
                    map.put("message","确认密码不一致！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","修改密码失败！");
        }
        return map;
    }

    //航司修改信息功能
    @RequestMapping(value = "/updatecompany",method = RequestMethod.POST)
    public Map<String,Object> updateCompany(@RequestParam Map<String,String> rawmap){
        Map<String,Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String email = rawmap.get("email");
        String name = rawmap.get("name");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                if(EmailUtil.isCorrect(email)) {
                    airlinecompany conflict = companyService.getCompanyByEmail(email, tokenentity.getId());
                    if (conflict != null) {
                        map.put("success", false);
                        map.put("message", "该邮箱已被使用！");
                    } else {
                        companyService.updateOldCompany(new airlinecompany(tokenentity.getId(), email, name, "", ""));
                        map.put("success", true);
                        map.put("message", "航司信息已更新！");
                    }
                }else{
                    map.put("success", false);
                    map.put("message", "邮箱格式有误！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "修改航司信息失败！");
        }
        return map;
    }

    //列出该航司的航班信息功能
    @RequestMapping(value = "/listflight",method = RequestMethod.POST)
    public Map<String,Object> listFlight(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                List<flight> rtlist = flightService.listFlightByCompanyid(tokenentity.getId());
                map.put("success", true);
                map.put("message", rtlist);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "获取列表失败！");
        }
        return map;
    }

    //航司添加航班信息功能
    @RequestMapping(value = "/addflight", method = RequestMethod.POST)
    public Map<String, Object> addFlight(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String name = rawmap.get("name");
        String takeofflocation = rawmap.get("takeofflocation");
        String landinglocation = rawmap.get("landinglocation");
        String departuretime = rawmap.get("departuretime");
        String landingtime = rawmap.get("landingtime");
        String departuregate = rawmap.get("departuregate");
        String terminal = rawmap.get("terminal");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                flight exist = flightService.getFlightByCombine(name,tokenentity.getId(),departuretime,0);
                if (exist != null) {
                    map.put("success", false);
                    map.put("message", "航班信息已存在！");
                } else {
                    if(takeofflocation.startsWith(TypeUtil.AirportLocation) || landinglocation.startsWith(TypeUtil.AirportLocation)) {
                        String keytime = landingtime;
                        if(takeofflocation.startsWith(TypeUtil.AirportLocation)){
                            keytime = departuretime;
                        }
                        String thatday = keytime.split(" ")[0]+"%";
                        List<runway> rylist = runwayService.listOccupyByRunway(TypeUtil.Runway.A1,thatday,0);
                        boolean isend = true;
                        for (runway ry : rylist) {
                            int ztime = TimeFormatUtil.getMinutes(ry.getTime());
                            int ntime = TimeFormatUtil.getMinutes(keytime);
                            if(ntime <= ztime+30 && ntime >= ztime-30){
                                isend = false;
                                break;
                            }
                        }
                        if(isend){
                            flightService.addNewFlight(new flight(0, name, tokenentity.getId(), takeofflocation, landinglocation, departuretime, landingtime, departuregate, Integer.parseInt(terminal)));
                            flight fl = flightService.getFlightByCombine(name, tokenentity.getId(),departuretime,0);
                            runwayService.addNewOccupy(new runway(fl.getFlightid(),keytime,TypeUtil.Runway.A1));
                            map.put("success", true);
                            map.put("message", "添加航班信息成功！");
                        }else {
                            rylist = runwayService.listOccupyByRunway(TypeUtil.Runway.A2,thatday,0);
                            isend = true;
                            for (runway ry : rylist) {
                                int ztime = TimeFormatUtil.getMinutes(ry.getTime());
                                int ntime = TimeFormatUtil.getMinutes(keytime);
                                if(ntime <= ztime+30 && ntime >= ztime-30){
                                    isend = false;
                                    break;
                                }
                            }
                            if(isend) {
                                flightService.addNewFlight(new flight(0, name, tokenentity.getId(), takeofflocation, landinglocation, departuretime, landingtime, departuregate, Integer.parseInt(terminal)));
                                flight fl = flightService.getFlightByCombine(name, tokenentity.getId(), departuretime, 0);
                                runwayService.addNewOccupy(new runway(fl.getFlightid(), keytime, TypeUtil.Runway.A2));
                                map.put("success", true);
                                map.put("message", "添加航班信息成功！");
                            }else{
                                map.put("success", false);
                                map.put("message", "无跑道可用！");
                            }
                        }
                    }else{
                        map.put("success", false);
                        map.put("message", "该航班不在管理范围内！");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "添加航班信息失败！");
        }
        return map;
    }

    //航司修改航班信息功能
    @RequestMapping(value = "/updateflight", method = RequestMethod.POST)
    public Map<String, Object> updateFlight(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String flightid = rawmap.get("flightid");
        String name = rawmap.get("name");
        String takeofflocation = rawmap.get("takeofflocation");
        String landinglocation = rawmap.get("landinglocation");
        String departuretime = rawmap.get("departuretime");
        String landingtime = rawmap.get("landingtime");
        String departuregate = rawmap.get("departuregate");
        String terminal = rawmap.get("terminal");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                flight conflict = flightService.getFlightByCombine(name,tokenentity.getId(),departuretime,Integer.parseInt(flightid));
                if(conflict != null){
                    map.put("success", false);
                    map.put("message", "已存在相同航班信息！");
                }else {
                    if(takeofflocation.startsWith(TypeUtil.AirportLocation) || landinglocation.startsWith(TypeUtil.AirportLocation)) {
                        String keytime = landingtime;
                        if(takeofflocation.startsWith(TypeUtil.AirportLocation)){
                            keytime = departuretime;
                        }
                        String thatday = keytime.split(" ")[0]+"%";
                        List<runway> rylist = runwayService.listOccupyByRunway(TypeUtil.Runway.A1,thatday,Integer.parseInt(flightid));
                        boolean isend = true;
                        for (runway ry : rylist) {
                            int ztime = TimeFormatUtil.getMinutes(ry.getTime());
                            int ntime = TimeFormatUtil.getMinutes(keytime);
                            if(ntime <= ztime+30 && ntime >= ztime-30){
                                isend = false;
                                break;
                            }
                        }
                        if(isend){
                            flightService.updateOldFlight(new flight(Integer.parseInt(flightid),name, tokenentity.getId(), takeofflocation, landinglocation, departuretime, landingtime, departuregate, Integer.parseInt(terminal)));
                            runwayService.updateOldOccupy(new runway(Integer.parseInt(flightid),keytime,TypeUtil.Runway.A1));
                            map.put("success", true);
                            map.put("message", "添加航班信息成功！");
                        }else {
                            rylist = runwayService.listOccupyByRunway(TypeUtil.Runway.A2,thatday,Integer.parseInt(flightid));
                            isend = true;
                            for (runway ry : rylist) {
                                int ztime = TimeFormatUtil.getMinutes(ry.getTime());
                                int ntime = TimeFormatUtil.getMinutes(keytime);
                                if(ntime <= ztime+30 && ntime >= ztime-30){
                                    isend = false;
                                    break;
                                }
                            }
                            if(isend) {
                                flightService.updateOldFlight(new flight(Integer.parseInt(flightid),name, tokenentity.getId(), takeofflocation, landinglocation, departuretime, landingtime, departuregate, Integer.parseInt(terminal)));
                                runwayService.updateOldOccupy(new runway(Integer.parseInt(flightid), keytime, TypeUtil.Runway.A2));
                                map.put("success", true);
                                map.put("message", "航班信息已更新！");
                            }else{
                                map.put("success", false);
                                map.put("message", "无跑道可用！");
                            }
                        }
                    }else{
                        map.put("success", false);
                        map.put("message", "该航班不在管理范围内！");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "修改航班信息失败！");
        }
        return map;
    }

    //航司删除航班信息功能
    @RequestMapping(value = "/removeflight", method = RequestMethod.POST)
    public Map<String, Object> removeFlight(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String flightid = rawmap.get("flightid");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                flightService.removeOldFlight(Integer.parseInt(flightid));
                map.put("success", true);
                map.put("message", "航班信息已删除！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "删除航班信息失败！");
        }
        return map;
    }

    //航司添加机票信息功能
    @RequestMapping(value = "/addticket", method = RequestMethod.POST)
    public Map<String, Object> addTicket(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String flightid = rawmap.get("flightid");
        String tickettype = rawmap.get("tickettype");
        String price = rawmap.get("price");
        String amount = rawmap.get("amount");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                ticket exist = ticketService.getTicketByCombine(Integer.parseInt(flightid),tickettype,0);
                if (exist != null) {
                    map.put("success", false);
                    map.put("message", "机票信息已存在！");
                } else {
                    ticketService.addNewTicket(new ticket(0,Integer.parseInt(flightid), tickettype, Double.parseDouble(price), Integer.parseInt(amount)));
                    map.put("success", true);
                    map.put("message", "添加机票信息成功！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "添加机票信息失败！");
        }
        return map;
    }

    //航司修改机票信息功能
    @RequestMapping(value = "/updateticket", method = RequestMethod.POST)
    public Map<String, Object> updateTicket(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String ticketid = rawmap.get("ticketid");
        String tickettype = rawmap.get("tickettype");
        String price = rawmap.get("price");
        String amount = rawmap.get("amount");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                ticket conflict = ticketService.getTicketByCombine(ticketService.getTicketByID(Integer.parseInt(ticketid)).getFlightid(),tickettype,Integer.parseInt(ticketid));
                if(conflict != null){
                    map.put("success", false);
                    map.put("message", "已存在相同机票信息！");
                }else {
                    ticketService.updateOldTicket(new ticket(Integer.parseInt(ticketid),0, tickettype, Double.parseDouble(price), Integer.parseInt(amount)));
                    map.put("success", true);
                    map.put("message", "机票信息已更新！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "修改机票信息失败！");
        }
        return map;
    }

    //航司删除机票信息功能
    @RequestMapping(value = "/removeticket", method = RequestMethod.POST)
    public Map<String, Object> removeTicket(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String ticketid = rawmap.get("ticketid");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                ticketService.removeOldTicket(Integer.parseInt(ticketid));
                map.put("success", true);
                map.put("message", "机票信息已删除！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "删除机票信息失败！");
        }
        return map;
    }

    //列出该航班的机票信息功能
    @RequestMapping(value = "/listticket",method = RequestMethod.POST)
    public Map<String,Object> listTicket(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");
        String flightid = rawmap.get("flightid");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                List<ticket> rtlist = ticketService.listTicketByFlightid(Integer.parseInt(flightid));
                map.put("success", true);
                map.put("message", rtlist);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "获取列表失败！");
        }
        return map;
    }

    //航司注销登录功能
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Map<String,Object> logoutCompany(@RequestParam Map<String,String> rawmap){
        Map<String, Object> map = new HashMap<>();

        //表单取参
        String companytk = rawmap.get("token");

        try {
            token tokenentity = tokenService.getTokenByToken(companytk,TypeUtil.Token.COMPANY);
            if(tokenentity == null){
                map.put("success", false);
                map.put("message", "航司未登录或已注销登录！");
            }else {
                tokenService.logoutOldToken(companytk,TypeUtil.Token.COMPANY);
                map.put("success", true);
                map.put("message", "航司注销登录成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "航司注销登录失败！");
        }
        return map;
    }

}

