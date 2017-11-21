package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        //  int number = 0;
        String numberString, s="сумма";
        int count = 0;
        while ((numberString=reader.readLine()).intern()!=s.intern()) {
            count = count + Integer.parseInt(numberString);
        }
        System.out.println(count);
    }
}

