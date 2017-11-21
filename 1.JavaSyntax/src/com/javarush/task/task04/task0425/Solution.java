package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
//        для первой четверти a>0 и b>0;
        if ((number1>0)&&(number2>0)){
            System.out.println(1);
        }
//        для второй четверти a<0 и b>0;
        if ((number1<0)&&(number2>0)){
            System.out.println(2);
        }
//        для третьей четверти a<0 и b<0;
        if ((number1<0)&&(number2<0)){
            System.out.println(3);
        }
//        для четвертой четверти a>0 и b<0.
        if ((number1>0)&&(number2<0)){
            System.out.println(4);
        }
    }
}
