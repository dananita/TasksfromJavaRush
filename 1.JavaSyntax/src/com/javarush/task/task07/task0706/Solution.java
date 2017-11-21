package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] iarr = new int[15];
        int evensum=0,oddsum=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <iarr.length; i++) {
            iarr[i]=Integer.parseInt(reader.readLine());
            if ((i%2)==0){
                evensum = evensum+iarr[i];
            }
            else{
                oddsum = oddsum + iarr[i];
            }
        }
        if (evensum>oddsum){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else{
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
