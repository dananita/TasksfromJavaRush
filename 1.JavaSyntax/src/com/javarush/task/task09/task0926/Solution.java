package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Collections;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> result = new ArrayList<>();
        int[] list5 = new int[5];
        for (int i = 0; i <5 ; i++) {
            list5[i]=i;
        }
        int[] list2 = new int[2];
        for (int i = 0; i <2 ; i++) {
            list2[i]=i+10;
        }
        int[] list4 = new int[4];
        for (int i = 0; i <4 ; i++) {
            list4[i]=i+100;
        }
        int[] list7 = new int[7];
        for (int i = 0; i <5 ; i++) {
            list7[i]=i+1000;
        }
        int[] list0 = new int[0];
        for (int i = 0; i <0 ; i++) {
            list7[i]=i+10000;
        }
        Collections.addAll(result,list5,list2, list4, list7, list0);
        return result;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
