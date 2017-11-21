package com.javarush.task.task07.task0707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList list = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        for (int i = 0; i <5 ; i++) {
            list.add(reader.readLine());
        }
        System.out.println(list.size());
        for (int j = 0; j <list.size() ; j++) {
            System.out.println(list.get(j));

        }
    }
}
