package com.javarush.task.task18.task1803;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    //    /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Task17.10
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> list =  new ArrayList<>();
        int countMaxrepeat=0;
        while (fileInputStream.available()>0){
            list.add(fileInputStream.read());
        }
        for (int i = 0; i <= list.size()-1; i++) {
            int count= Collections.frequency(list,list.get(i));
            countMaxrepeat = count<countMaxrepeat ? countMaxrepeat:count;
        }
        String s="";
        for (int i = 0; i <= list.size()-1; i++) {
            int count= Collections.frequency(list,list.get(i));
            if (count == countMaxrepeat){
                if (!s.contains(list.get(i).toString())){
                    s=s+" "+list.get(i);
                }
            }
        }
        System.out.println(s);
        fileInputStream.close();
        reader.close();
    }
}
