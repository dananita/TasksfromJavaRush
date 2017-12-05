package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Подсчет запятых
*/
 // Ascii - код ',' = 44
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/data.txt
public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            int countcomma = 0;
            while (file.available()>0){
                if (file.read()==44) countcomma++;
            }
            file.close();
            System.out.println(countcomma);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
