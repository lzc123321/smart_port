package com.example.finalpro.config;

public class TypeUtil {
    public static String AirportLocation = "襄阳";

    public static class Staff {
        public static Integer ADMINISTRATOR = 0;
        public static Integer COMMONSTAFF = 1;
        public static Integer REPAIRSTAFF = 2;
        public static Integer CUSTOMERSERVICE = 3;
    }

    public static class Seat {
        public static Integer TRUE = 1;
        public static Integer FALSE = 0;
        public static Integer MINE = 2;
    }

    public static class Approve{
        public static Integer ACCESS = 1;
        public static Integer DENY = 0;
        public static Integer UNSOLVED = 2;
    }

    public static class Token{
        public static final int TOURIST = 0;
        public static final int MERCHANT = 1;
        public static final int STAFF = 2;
        public static final int COMPANY = 3;
    }

    public static class Schedule{
        public static String TAKEOFF = "正在起飞";//起飞时间开始的10min
        public static String LANDING = "正在降落";//降落时间之前的10min
        public static String FLY = "飞行中";//除起飞和降落时间均为飞行中
        public static String CHECK = "值机中";//起飞前2hour开始值机
        public static String ABOARD = "正在登机";//起飞前30min开始登机
        public static String STOP = "停止登机";//起飞前10min停止登机
    }

    public static class Status{
        public static String USING = "使用中";
        public static String BOOK = "已预定";
        public static String OLD = "历史记录";
    }

    public static class Runway{
        public static Integer A1 = 1;
        public static Integer A2 = 2;
    }
}