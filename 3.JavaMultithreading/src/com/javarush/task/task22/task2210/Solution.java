package com.javarush.task.task22.task2210;

import java.util.*;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

        String [] words = getTokens("level22.lesson13.task01",".");
        for (int i = 0; i < words.length ; i++) {
            System.out.println(words[i]);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query,delimiter);
        List tempListResult = new ArrayList();

        while (stringTokenizer.hasMoreTokens()){
            tempListResult.add(stringTokenizer.nextToken());
        }

        String [] result = new String[tempListResult.size()];
        tempListResult.toArray(result);
        return result;
    }
}
