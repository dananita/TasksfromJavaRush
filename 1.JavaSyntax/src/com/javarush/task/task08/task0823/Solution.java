package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String str[] = new String[s.length()];
        char c[] = s.toCharArray();
        c[0]=Character.toUpperCase(c[0]);
        for (int i = 0; i <s.length() ; i++) {
            if (c[i]==' '){
                c[i+1]=Character.toUpperCase(c[i+1]);
            }
            System.out.print(c[i]);
        }
        //напишите тут ваш код
    }
}
