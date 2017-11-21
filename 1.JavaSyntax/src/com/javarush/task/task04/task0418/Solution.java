package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String s = Integer.toString(minimum(Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine())));
        System.out.println(s);
    }
    public static  int minimum (int a, int b){
        int result;
        if (a<=b){
            result=a;
        }
        else {result = b;}
        return result;

    }

}