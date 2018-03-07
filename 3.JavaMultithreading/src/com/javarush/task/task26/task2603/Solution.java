package com.javarush.task.task26.task2603;

import java.util.Arrays;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
            Comparator<T> acc = (o11, o21) -> 0;
            for (Comparator<T> comparator : comparators) {
                acc = acc.thenComparing(comparator);
            }
            return acc.compare(o1, o2);
            /*int result = 0;
            for (Comparator t: comparators) {
                result = t.compare(o1, o2);
                if (result != 0) break;
            }
            return result;*/
        }
    }
}
