package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        int count = 1;
        int max = 1;
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));

        }


        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i) == list.get(i + 1)) {
                count++;
                if (max < count) {
                    max = count;

                }
            } else {
                count = 1;
            }


        }
        System.out.println(max);
    }
    /*   //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s= reader.readLine();
        int count=1,maxcount=0;
        for (int i = 0; i <10 ; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        *//*for (int i = 0;i<s.length();) {
            int k = s.indexOf(',',i);
            if (k==-1)k=s.length();
                list.add(Integer.parseInt((s.substring(i, k)).trim()));
                i = k + 1;

        }*//*

        for (int i = 0; i <list.size() ; i++) {
            if ((i!=0)&&(list.get(i-1).equals(list.get(i)))){
                count++;
                if (count>maxcount){
                    maxcount=count;
                }
            }
            else {
                count=1;
            }
        }
        System.out.println(maxcount);
    }*/
}