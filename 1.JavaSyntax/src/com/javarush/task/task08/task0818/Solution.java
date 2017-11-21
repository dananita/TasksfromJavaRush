package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Иванов",40);
        map.put("Смирнов",100);
        map.put("Петров",600);
        map.put("Миронова",2);
        map.put("Журавель",700);
        map.put("Клопов",10);
        map.put("Иранов",400);
        map.put("Десков",550);
        map.put("Ласков",760);
        map.put("Васьков",490);
        //System.out.println(map);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> key = new ArrayList<>();
        for (Map.Entry<String,Integer> p : map.entrySet()) {
            if(p.getValue()< 500){
                key.add(p.getKey());
            }
        }
        for (String k:key) {
            map.remove(k);
        }
    }

    public static void main(String[] args) {
    HashMap map = createMap();
    removeItemFromMap(map);
      //  System.out.println(map);
    }
}