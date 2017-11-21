package com.javarush.task.task08.task0816;

import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stall", new Date("JULY 1 1980"));
        map.put("St", new Date("MAY 1 1980"));
        map.put("Stallon", new Date("MAY 1 1980"));
        map.put("Stal", new Date("OCTOBER 1 1980"));
        map.put("Stallo", new Date("SEPTEMBER 1 1980"));
        map.put("S", new Date("NOVEMBER 1 1980"));
        map.put("Stallona", new Date("DECEMBER 1 1980"));
        map.put("Stask", new Date("DECEMBER 1 1980"));
        map.put("Sud", new Date("AUGUST 1 1980"));
        return map;
            //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry p = (Map.Entry) it.next();
            if(p.getValue().toString().contains("Jun")){
                it.remove();
            }
            if (p.getValue().toString().contains("Jul")){
                it.remove();
            }
            if (p.getValue().toString().contains("Aug")){
                it.remove();
            }
        }
        /*for (Map.Entry p: map.entrySet()) {
            if (p.getValue().toString().contains("Jun")){
                map.remove(p);
            }
            if (p.getValue().toString().contains("Jul")){
                map.remove(p);
            }
            if (p.getValue().toString().contains("Aug")){
                map.remove(p);
            }
        }*/
        /*for (Map.Entry p : map.entrySet()) {
            System.out.println(p.getKey()+" "+p.getValue());
        }*/
    }

    public static void main(String[] args) {
    HashMap map = createMap();
    removeAllSummerPeople(map);
    }
}
