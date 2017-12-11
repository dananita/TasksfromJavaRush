package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream file = new FileInputStream(args[0]);
        int tempOneByte;
        int countAllChar =0;
        int countSpace =0;

        while ((tempOneByte=file.read())!=-1) {
            countAllChar++;
            if (tempOneByte==32) countSpace++;
        }

        file.close();

        System.out.println(new DecimalFormat("#0.00")
                .format((double)countSpace/countAllChar*100));
    }
}
