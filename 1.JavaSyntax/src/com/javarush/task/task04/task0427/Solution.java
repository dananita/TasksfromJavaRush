package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        if ((number1 >= 1) && (number1 <= 999)) {
            System.out.println(poisk(number1));
        }

    }

    public static String poisk(int number1) {
        int count = 0;
        double k;
        String s="";
        for (int i = 3; i >= 1; i--) {
            k = number1 / Math.pow(10, i);
            //System.out.println(k);
            if (k >=1) {
                count = count + 1;
             //   System.out.println(count);
            }

        }
        if (count == 0) {
            if ((number1 % 2) == 0) {
                s = "четное однозначное число";
            } else {
                s = "нечетное однозначное число";
            }
        } else if (count == 1) {
            if ((number1 % 2) == 0) {
                s = "четное двузначное число";
            } else {
                s = "нечетное двузначное число";
            }
        } else if (count == 2) {
            if ((number1 % 2) == 0) {
                s = "четное трехзначное число";
            } else {
                s = "нечетное трехзначное число";
            }
        }
        return s;
    }
}

