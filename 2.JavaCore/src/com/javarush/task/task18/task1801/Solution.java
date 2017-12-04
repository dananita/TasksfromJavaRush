package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Task17.10

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int maxElement = -127;
        while (fileInputStream.available() > 0) {
            int i = fileInputStream.read();
            maxElement = maxElement <= i ? i : maxElement;
        }
        System.out.println(maxElement);
        fileInputStream.close();
        reader.close();
    }
}
