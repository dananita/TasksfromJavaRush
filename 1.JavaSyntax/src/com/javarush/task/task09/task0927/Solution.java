package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<>();
        map.put("Murka",new Cat("Murka"));
        map.put("Murzik",new Cat("Murzik"));
        map.put("Vaska",new Cat("Vaska"));
        map.put("Ponka",new Cat("Ponka"));
        map.put("Murk",new Cat("Murk"));
        map.put("Larka",new Cat("Larka"));
        map.put("Sorka",new Cat("Sorka"));
        map.put("Oktava",new Cat("Oktava"));
        map.put("Urka",new Cat("Urka"));
        map.put("Lurv",new Cat("Lurv"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<>();
        for (Map.Entry p:map.entrySet()) {
            set.add(map.get(p.getKey()));
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
