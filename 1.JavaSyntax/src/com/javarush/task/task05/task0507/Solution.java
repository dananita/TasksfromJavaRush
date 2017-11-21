package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberreader=0, count = 0, sizereader = 0;
        while ((numberreader=Integer.parseInt(reader.readLine()))!=-1){
            count = count+numberreader;
            sizereader=sizereader+1;
        }
        System.out.println((double)count/sizereader);
    }
}

