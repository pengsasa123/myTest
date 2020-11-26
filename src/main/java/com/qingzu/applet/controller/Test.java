package com.qingzu.applet.controller;

import com.qingzu.applet.result.City;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {


//        private static final double PI = 3.14159265;
//        private static final double EARTH_RADIUS = 6378137;
//        private static final double RAD = Math.PI / 180.0;

        //@see http://snipperize.todayclose.com/snippet/php/SQL-Query-to-Find-All-Retailers-Within-a-Given-Radius-of-a-Latitude-and-Longitude--65095/
        //The circumference of the earth is 24,901 miles.
        //24,901/360 = 69.17 miles / degree
        /**
         * @param raidus 单位米
         * return minLat,minLng,maxLat,maxLng
         */
        public static double[] getAround(double lat,double lon,int raidus){

            Double latitude = lat;
            Double longitude = lon;

            Double degree = (24901*1609)/360.0;
            double raidusMile = raidus;

            Double dpmLat = 1/degree;
            Double radiusLat = dpmLat*raidusMile;
            Double minLat = latitude - radiusLat;
            Double maxLat = latitude + radiusLat;

            LocalDateTime now = LocalDateTime.now();

            Double mpdLng = degree*Math.cos(latitude * (Math.PI/180));
            Double dpmLng = 1 / mpdLng;
            Double radiusLng = dpmLng*raidusMile;
            Double minLng = longitude - radiusLng;
            Double maxLng = longitude + radiusLng;
            System.out.println("=======minLat======"+minLat);
            System.out.println("=======maxLat======"+maxLat);
            System.out.println("=======minLng======"+minLng);
            System.out.println("=======maxLng======"+maxLng);
            //System.out.println(&quot;[&quot;+minLat+&maxLng;,&quot;+minLng+&quot;,&quot;+maxLat+&quot;,&quot;+maxLng+&quot;]&quot;);
            return new double[]{minLat,minLng,maxLat,maxLng};
        }
    public static void main(String[] args) {

        //System.out.println("123dsafagagagggag".substring(0,12))

         /*LocalDate endTime;
        if (0 == rentYearKey) {
            endTime = time.plusMonths(6).minusDays(1L);
        } else {
            endTime = time.plusYears(rentYearKey).minusDays(1L);
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String endFormat = dateTimeFormatter.format(endTime);
        String[] split = endFormat.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        //当结束日期不是闰年 而且为2月28号的时候
        if (year % 4 != 0 && month == 2 && day == 27) {
            endTime = endTime.plusDays(1);
        }
        //当结束日期是闰年,而且为2月29号的时候
        if (year % 4 == 0 && month == 2 && day == 28) {
            endTime = endTime.plusDays(1);
        }
        Date from = Date.from(endTime.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        contract.setEndTime(from);*/


       /* //合同结束时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        if (0 == rentYearKey) {
            calendar.add(Calendar.MONTH, 6);
        }
        calendar.add(Calendar.MONTH, rentYearKey * 12);
        try {
            String end = format.format(calendar.getTime());
            System.out.println("---------------->" + end);
            String[] split = end.split("-");
            int year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            Date time = format.parse(end);
            long t = 0l;
            if (year % 4 != 0 && month == 2 && day == 28) {
                t = time.getTime();
            } else if (year % 4 == 0 && month == 2 && day == 29) {
                t = time.getTime();
            } else {
                t = time.getTime() - 24 * 60 * 60 * 1000L;
            }
            Date endTime = new Date(t);
            contract.setEndTime(endTime);
            //下次交租时间
            Calendar c = Calendar.getInstance();
            c.setTime(startTime);
            c.add(Calendar.MONTH, 1);
            String next = format.format(c.getTime());
            Date nextPayTime = format.parse(next);
            contract.setNextPayTime(nextPayTime);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("异常", e);
        }*/
    }
}
