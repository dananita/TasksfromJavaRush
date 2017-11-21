package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(reader.readLine());
        if (line ==0){
            System.out.println(line);
        }
        else if (line>0){
            System.out.println(line*2);
        }
        else if (line<0){
            System.out.println(line+1);
        }

    }

}