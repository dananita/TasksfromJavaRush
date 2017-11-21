package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/


public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] iarr = new int[10];
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        for (int i=0; i<10;i++){
            iarr[i]=Integer.parseInt(reader.readLine());
        }
        int changeriarr=0;
        for (int i=0;i<=iarr.length/2-1;i++){
            changeriarr=iarr[i];
            iarr[i]=iarr[iarr.length-i-1];
            iarr[iarr.length-i-1]=changeriarr;
        }
        for (int k =0;k<10;k++){
            System.out.println(iarr[k]);
        }

    }
}

