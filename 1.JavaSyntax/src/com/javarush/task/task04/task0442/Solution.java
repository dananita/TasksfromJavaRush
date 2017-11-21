package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int numberReader;
            int count = 0;
            while ((numberReader = Integer.parseInt(reader.readLine())) != -1) {
                count = count + numberReader;
            }
            System.out.println(count - 1);
    }
}
