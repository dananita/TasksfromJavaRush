package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
        return (double)i*0.10 + i;
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
