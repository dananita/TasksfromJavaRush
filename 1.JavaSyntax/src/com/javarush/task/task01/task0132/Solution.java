package com.javarush.task.task01.task0132;


/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int result = 0, preresult = number;
        for (int i = 2; i >= 0 ; i--) {
            result = result+preresult/(int)Math.pow(10,(double)i);
            preresult = preresult%(int)Math.pow(10,(double)i);
        }
        return result;
    }
}