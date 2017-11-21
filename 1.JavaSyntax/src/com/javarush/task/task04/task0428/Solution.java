package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());
        int iArr[] = {number1,number2,number3};
        int countnumber = 0;
        for (int i = 0; i <iArr.length ; i++) {
        if (iArr[i]>0) {
            countnumber = countnumber+1;}
        }
        System.out.println(countnumber);
    }
}
