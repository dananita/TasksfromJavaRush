package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<Character> listVowels = new ArrayList<>();
        ArrayList<Character> listother = new ArrayList<>();
        for (int i = 0; i <s.length() ; i++) {
            if (isVowel(s.charAt(i))){
                listVowels.add(s.charAt(i));
            }
            else{
                if (s.charAt(i)!=' '){
                    listother.add(s.charAt(i));
                }
            }
        }
        for (int i = 0; i <listVowels.size() ; i++) {
            System.out.print(listVowels.get(i)+ " ");
        }
        System.out.println();
        for (int i = 0; i <listother.size() ; i++) {
            System.out.print(listother.get(i)+ " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}