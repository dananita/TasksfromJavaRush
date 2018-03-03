package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer [] array = {13, 8, 15, 17};
        array = sort(array);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        final double medianaArray;
        Arrays.sort(array);
        if (array.length % 2 == 0){
            medianaArray = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        } else {
            medianaArray = array[array.length / 2];
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double result = Math.abs(o1 -medianaArray) - Math.abs(o2 -medianaArray);
                if (result == 0) {
                    result = o1 - o2;
                }
                return (int) result;
            }
        });
        return array;
    }
}
