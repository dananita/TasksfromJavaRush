package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<>();
        map.put("Ivanov", "Kate");
        map.put("Ivanov", "Kate");
        map.put("Ivanov", "Kate");
        map.put("Ivanov", "Kate");
        map.put("Ivanov", "Kate");
        map.put("Ivanov", "Kat");
        map.put("Ivanov", "Elisa");
        map.put("Ivanov", "Mira");
        map.put("Ivanov", "Irina");
        map.put("Ivanov", "Leto");
        map.put("Smit", "Kat6");
        map.put("Smitty", "Kat5");
        map.put("Elis", "Kat4");
        map.put("Kwa", "Kat3");
        map.put("Gurinov", "Kate2");
        map.put("Los", "Kate1");
        map.put("Miry", "Kate");
        map.put("Monk", "Kate");
        map.put("Gol", "Kate");
        map.put("Lurionov", "Kate");
        map.put("Samov", "Kate");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
