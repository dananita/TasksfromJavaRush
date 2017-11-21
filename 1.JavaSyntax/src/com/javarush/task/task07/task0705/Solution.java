package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] iarrbig = new int[20];
        int[] iarrsmall1 = new int[10];
        int[] iarrsmall2 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            iarrbig[i] = Integer.parseInt(reader.readLine());
            if (i<10){
                iarrsmall1[i]=iarrbig[i];
            }
            else{
                iarrsmall2[i-10]=iarrbig[i];
            }
        }
        for (int j = 0; j <10 ; j++) {
            System.out.println(iarrsmall2[j]);
        }

    }
}
