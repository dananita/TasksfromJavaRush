package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());
        int number4 = Integer.parseInt(reader.readLine());
        System.out.println(maximum(number1,number2,number3,number4));
    }
    public static int maximum (int a, int b){
        if (a>=b){
            return a;
        }
        else {return b;}
    }
    public static int maximum (int a, int b, int c, int d){
        int result1 = maximum(a,b);
        int result2 = maximum(c,d);
        return (maximum(result1,result2));
    }
}
