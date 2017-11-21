package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        String s="";
        for (int i = 0; i < number1; i++) {
            for (int j = 0; j < number2; j++) {
                s=s+8;
            }
            System.out.println(s);
            s="";
        }

    }
}
