package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
         //напишите тут ваш код
        HashMap<String,String> map = new HashMap();
        map.put("Letrov","Ivan");
        map.put("Muriol","Ivan");
        map.put("Gurav","Alex");
        map.put("Murova","Flur");
        map.put("Kozlov","Ivan");
        map.put("Lercov","Ivan");
        map.put("Luskov","Ivan");
        map.put("Sudnad","Ivan");
        map.put("Sunav","Ivan");
        map.put("Morev","Ivan");
        System.out.println(map);
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> duplicates = new ArrayList();
        ArrayList<String>key = new ArrayList<>();
        for (Map.Entry p:map.entrySet()) {
            String s= p.getValue().toString();
            if(duplicates.contains(p.getValue())) {
                key.add(p.getValue().toString());
            }
            else {
                duplicates.add(p.getValue().toString());
            }
        }
        for (String p:key) {
            removeItemFromMapByValue(map,p);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    HashMap map = createMap();
    removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }
}
