package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", null);
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder resultQuery = new StringBuilder();
        if (params != null || !params.isEmpty()) {
            for (Map.Entry<String, String> p :
                    params.entrySet()) {
                if (p.getKey() == null || p.getValue() == null) continue;
                if (resultQuery.length() == 0) {
                    resultQuery.append(p.getKey()).append(" = '").append(p.getValue()).append("'");
                } else {
                    resultQuery.append(" and ").append(p.getKey()).append(" = '").append(p.getValue()).append("'");
                }
            }
        }
        return resultQuery.toString();
    }
}
