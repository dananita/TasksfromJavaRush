package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {

// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Task17.10
    public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            int minElement = 128;
            while (fileInputStream.available() > 0) {
                int i = fileInputStream.read();
                minElement = minElement <= i ? minElement : i;
            }
            System.out.println(minElement);
            fileInputStream.close();
            reader.close();
    }
}
