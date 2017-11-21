package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        LatteMaker l = new LatteMaker();
        TeaMaker t = new TeaMaker();
        l.makeDrink();
        t.makeDrink();
    }
}
