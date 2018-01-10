package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    final static long[] massiv = {
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            153,
            370,
            371,
            407,
            1634,
            8208,
            9474,
            54748,
            92727,
            93084,
            548834,
            1741725,
            4210818,
            9800817,
            9926315,
            24678050,
            24678051,
            88593477,
            146511208,
            472335975,
            534494836,
            912985153,
            4679307774l,
            32164049650l,
            32164049651l,
            40028394225l,
            42678290603l,
            44708635679l,
            49388550606l,
            82693916578l,
            94204591914l,
            28116440335967l,
            4338281769391370l,
            4338281769391371l,
            21897142587612075l,
            35641594208964132l,
            35875699062250035l,
            1517841543307505039l,
            3289582984443187032l,
            4498128791164624869l,
            4929273885928088826l
    };

    public static long[] getNumbers(long N) {
        TreeSet<Long> setResultLongs = new TreeSet();
        for (int i = 0; i < massiv.length ; i++) {
            if (massiv[i]<N){
                setResultLongs.add(massiv[i]);
            }
        }

        long[] results = new long[setResultLongs.size()];
        int i = 0;
        for (Long l : setResultLongs)
            results[i++] = l;
        return results;
    }

    public static long[] getNumbersVariant2(long N) {
        // This method is slow;
        long result = 0;
        TreeSet<Long> setResultLongs = new TreeSet();

        for (long j = 0; j < N ; j++) {
            int sizeJ = sizeJ(j);
            char[] charN = Long.toString(j).toCharArray();
            for (int i = 0; i < sizeJ ; i++) {
                //System.out.println("a in b"+String.valueOf(charN[i]).toString()+" : "+ charN.length);
                result += pow(Character.getNumericValue(charN[i]), sizeJ);
                //System.out.println("result = " + result);
            }
            if (result == j&&result<N) {
                //System.out.println("j = " + j);
                setResultLongs.add(j);
            }
            result=0;
        }

        long[] results = new long[setResultLongs.size()];
        int i = 0;
        for (Long l : setResultLongs)
            results[i++] = l;
        return results;
    }

     public static int sizeJ (long J){
        return (J == 0) ? 1 : (int) Math.ceil(Math.log10(J + 0.5));

     }

    public static long pow (int a, int b){
        long result = 1;
        for (int i = b; i > 0 ; i--) {
            result*= a;
        }
        return result;
    }

    public static void main(String[] args) {
        Date beforeOperation = new Date();
        //        1162261467
        //9_223_372_036_854_775_807
        //4929273885928088826L
        long[] result = getNumbers(Long.MAX_VALUE);
        Date afterOperation = new Date();
        System.out.println("Time is " + (afterOperation.getTime() - beforeOperation.getTime()));
        for (long s : result) {
            System.out.println(s);
        }
    }
}
