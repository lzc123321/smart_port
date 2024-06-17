package com.example.finalpro.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatUtil {
    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final int[] monthdays = {31,28,31,30,31,30,31,31,30,31,30,31};

    private static boolean isLeapYear(Integer year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private static int countDays(Integer year,Integer month){
        int days = 0;
        for(int i=0;i<month;i++){
            days = days + monthdays[i];
            if(i==1 && isLeapYear(year))days = days + 1;
        }
        return days;
    }

    public static String getCurrentTime(){
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static int getMinutes(String time){
        String[] dtime = time.split(" ")[1].split(":");
        int dhour = Integer.parseInt(dtime[0]);
        int dmin = Integer.parseInt(dtime[1]);
        return dhour*60+dmin;
    }

    public static int getDays(String date){
        String[] dtime = date.split(" ")[0].split("-");
        int year = Integer.parseInt(dtime[0]);
        int month = Integer.parseInt(dtime[1]);
        int day = Integer.parseInt(dtime[2]);
        return countDays(year,month-1)+day;
    }
}
