package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        int maximum = -128, number, i=1;
        if ((number = Integer.parseInt(reader.readLine())) > 0) {
           while (i<=number){
               maximum = max(maximum, Integer.parseInt(reader1.readLine()));
               i++;
            }
            System.out.println(maximum);
        }
    }
    public static int max(int a,int b){
        return a<b ? b:a;
    }
}
