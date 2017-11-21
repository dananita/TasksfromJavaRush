package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(3.4,"masha");
        labels.put(3.5,"masha2");
        labels.put(3.6,"masha3");
        labels.put(3.7,"masha4");
        labels.put(3.8,"masha5");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
