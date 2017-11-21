package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String iarr[] = new String [10];
        int jarr[]= new int [10];
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        for (int i=0; i<10; i++){
            iarr[i] = reader.readLine();
            jarr[i] = iarr[i].length();
        }
        for (int j = 0; j <10 ; j++) {
            System.out.println(jarr[j]);
        }
    }
}
