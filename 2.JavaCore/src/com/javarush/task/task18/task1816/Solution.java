package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream file = new FileInputStream(args[0]);
        int oneByte;
        int count =0;

        while ((oneByte=file.read())!=-1) {
            if (((oneByte>=65)&&(oneByte<=90))||((oneByte>=97)&&(oneByte<=122)))
                count++;
        }
        file.close();
        System.out.println(count);
    }

}
