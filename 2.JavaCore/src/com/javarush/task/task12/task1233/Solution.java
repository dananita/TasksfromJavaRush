package com.javarush.task.task12.task1233;

/* 
Задача по алгоритмам
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, -8, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }
        Integer i=array[0];
        Integer count =0;
        for (int j = 1; j < array.length; j++) {
            if(i >= array[j]){
                i=array[j];
                count=j;}
        }
        //напишите тут ваш код
        return new Pair<Integer, Integer>(i, count);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
