package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    /*public static String recursion(int a, int b) {
        if (a > b) {
            return a + " " + recursion(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + recursion(a + 1, b);
        }
    }
*/
    public static String getAllNumbersBetween(int a, int b){
        StringBuilder result = new StringBuilder();
        if (a == b){
            result = result.append(a);
        } else if (a > b){
            for (int i = a; i >= b ; i--) {
                result = result.append(i);
                if (i != b){
                    result.append(" ");
                }
            }
        } else if(a < b) {
            for (int i = a; i <= b ; i++) {
                result = result.append(i);
                if (i != b){
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        //System.out.println(recursion(numberA, numberB));
        //System.out.println(recursion(numberB, numberA));
        System.out.println(getAllNumbersBetween(numberA,numberB));
        System.out.println(getAllNumbersBetween(numberB,numberA));
    }
}