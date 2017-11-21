package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(2,38));
        System.out.println(convertEurToUsd(5,35.5));
    }

    public static double convertEurToUsd(int eur, double course) {
        return (double) eur*course;

    }
}
