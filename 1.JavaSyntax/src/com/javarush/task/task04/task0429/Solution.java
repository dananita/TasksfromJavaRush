package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());
        int iArr[] = {number1,number2, number3};
        int count1= 0, count2 =0;
        for (int i = 0; i <iArr.length ; i++) {
            if (iArr[i]>0){
                count1=count1+1;
            }
            else {
                count2=count2+1;
            }
        }
        System.out.println("количество отрицательных чисел: "+count2);
        System.out.println("количество положительных чисел: "+count1);

    }
}
