package com.qingzu.applet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class java8Test {
    /***
     *
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
     * @return
     */

    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /***
     * convert Date to cron ,eg.  "0 07 10 15 1 ? 2016"
     * @param date  : 时间点
     * @return
     */
    public String getCron(java.util.Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }

    public static Double ifNUll(Double object){
        if(object == null){
            return 0.00;
        }
        return object;
    }

    public static int answer(int sum){
        if(sum == 1){
            return sum;
        }else{
            if(sum%2==1){
                sum = 3*sum + 1;
                System.out.println(sum);
                return answer(sum);
            }else {
                sum = sum/2;
                System.out.println(sum);
                return answer(sum);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] brr = new int[5];
        System.arraycopy(arr,2,brr,0,5);
       for(int i = 0;i<brr.length;i++){
           System.out.println(brr[i]);
        }

        Double a = null;
        Double aDouble = ifNUll(a);
        System.out.println(aDouble);
    }

    public static int answer (int n ,int sum){
        if(n>0){
            sum = 2*sum+2;
            if(n-1>0){
                System.out.println("第"+(n-1)+"个村庄卖出"+(2*sum+2-sum));
            }
            n--;
            return answer(n,sum);
        }else {
            return sum;
        }
    }

    public static long factorial(int n) {
        if (n == 1) return 1;
        return factorial(n - 1)*n;
    }

}
