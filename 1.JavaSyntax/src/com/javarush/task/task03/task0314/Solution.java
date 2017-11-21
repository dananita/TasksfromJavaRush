package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        for (int i=1; i<11; i++) {
            multiplay(i);
        }
    }
    public static void multiplay(int i){
        for (int j = 1; j<11;j++){
            System.out.print(j*i+" ");
        }
        System.out.println();
    }
}
