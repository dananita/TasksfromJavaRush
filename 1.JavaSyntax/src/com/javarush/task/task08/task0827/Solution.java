package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("Jan 2 2013"));
    }

    public static boolean isDateOdd(String date) {
     Date currentdate = new Date(date);
     Date yeardate = new Date(currentdate.getYear(),0,1);
     Date differencedate = new Date(yeardate.getTime()-currentdate.getTime());
     return ((differencedate.getTime()/(1000*24*60*60))%2==0)?true:false;
    }
}
