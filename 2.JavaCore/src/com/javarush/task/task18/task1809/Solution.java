package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/data.txt  // входящий файл
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/result.txt // исходящий файл

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileinput = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            FileOutputStream fileoutput = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            ArrayList <Integer> list = new ArrayList();
            while (fileinput.available()>0){
                list.add(fileinput.read());
            }
            Collections.reverse(list);
            for (int i = 0; i <=list.size()-1 ; i++) {
                 fileoutput.write(list.get(i));
            }
            fileinput.close();
            fileoutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
