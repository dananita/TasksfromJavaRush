package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/data.txt  // входящий файл
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/result.txt // исходящий файл
// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/result2.txt // исходящий файл

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileinput = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            FileOutputStream fileoutput1 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            FileOutputStream fileoutput2 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            ArrayList<Integer> list = new ArrayList();
            while (fileinput.available()>0){
                list.add(fileinput.read());
            }
            for (int i = 0; i <=list.size()-1 ; i++) {
                if (list.size()%2==0){
                    if (i<=((list.size())/2)-1){
                        fileoutput1.write(list.get(i));
                    } else {
                        fileoutput2.write(list.get(i));
                    }
                } else {
                    if (i<=((list.size())/2)){
                        fileoutput1.write(list.get(i));
                    } else {
                        fileoutput2.write(list.get(i));
                    }
                }
            }

            fileinput.close();
            fileoutput1.close();
            fileoutput2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
