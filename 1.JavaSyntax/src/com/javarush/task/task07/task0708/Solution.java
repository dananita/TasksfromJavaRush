package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/


public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        int weight=0;
        for (int i=0; i<5;i++){
            list.add(reader.readLine());
            if (weight<=list.get(i).length()){
             weight=list.get(i).length();
            }
        }
        for (int j = 0; j <list.size() ; j++) {
            if(list.get(j).length()==weight){
                System.out.println(list.get(j));
            }
        }

    }
}
