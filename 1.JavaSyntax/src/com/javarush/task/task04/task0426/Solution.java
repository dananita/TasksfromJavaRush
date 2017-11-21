package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        if (number1==0){
            System.out.println("ноль");
        }
        else if (number1>0){
            if ((number1%2)==0){
                System.out.println("положительное четное число");
            }
            else {
                System.out.println("положительное нечетное число");
            }
        }
        else if (number1<0){
            if ((number1%2)==0){
                System.out.println("отрицательное четное число");
            }
            else {
                System.out.println("отрицательное нечетное число");
            }
        }
    }
}
