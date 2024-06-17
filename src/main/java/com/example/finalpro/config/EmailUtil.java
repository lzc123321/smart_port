package com.example.finalpro.config;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//邮件发送工具类
/*
邮箱配置信息：通过USERNAME和PASSWORD常量存储邮件发送者的信息，如SMTP服务器地址、用户名、密码。

packUpEmail方法：初始化一个Apache Commons HtmlEmail实例，设置SMTP服务器的相关参数，如主机名、字符集、SSL连接等。

isCorrect方法：校验输入的电子邮件地址是否有效，检查域名后缀是否常见（如.com、 cn、 org、gov）。

sendAuthCodeEmail方法：向指定邮箱发送包含验证码的HTML格式邮件，验证码用于验证用户身份。

sendInformationEmail方法：向指定邮箱发送普通消息通知的HTML格式邮件。

注意：本项目中使用的邮箱为QQ邮箱，若使用其他邮箱，请修改相关配置信息。
 */


public class EmailUtil {

    private static final String USERNAME = "2042593039@qq.com";
    private static final String PASSWORD = "tzwwnffwonxkdbga";


    public static boolean isCorrect(String email) {
        String[] spt = email.split("@");
        if(spt.length == 2){
            String[] spt1 = spt[1].split("\\.");
            String test = spt1[spt1.length-1];
            return test.equals("com") || test.equals("cn") || test.equals("org") || test.equals("gov");
        }else {
            return false;
        }
    }

    public static void sendInformationEmail(String email, String s) {
        try {
            HtmlEmail mail = packUpEmail();
            /*发送邮件的邮箱和发件人*/
            mail.setFrom(USERNAME, "智慧机场系统");
            /*接收的邮箱*/
            mail.addTo(email);
            /*设置邮件的主题*/
            mail.setSubject("智慧机场系统消息通知");
            /*设置邮件的内容*/
            mail.setMsg(s);
            mail.send();//发送
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HtmlEmail packUpEmail() {
        HtmlEmail mail = new HtmlEmail();
        /*发送邮件的服务器 126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com*/
        mail.setHostName("smtp.qq.com");
        /*不设置发送的消息有可能是乱码*/
        mail.setCharset("UTF-8");
        /*IMAP/SMTP服务的密码 username为你开启发送验证码功能的邮箱号 password为你在qq邮箱获取到的一串字符串*/
        mail.setAuthentication(USERNAME, PASSWORD);
        /*使用安全链接*/
        mail.setSSLOnConnect(true);
        return mail;
    }
}
