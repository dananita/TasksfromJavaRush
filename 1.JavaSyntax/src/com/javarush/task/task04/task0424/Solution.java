package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());
        if ((number1 == number2) && (number2 == number3)) {
            return;
        } else if ((number1 != number2) && (number2 == number3)) {
            n = 1;
        } else if ((number1 == number2) && (number1 != number3)) {
            n = 3;
        } else if (number1 == number3) {
            n = 2;
        } else {
            return;
        }
        System.out.println(n);
    }
}

