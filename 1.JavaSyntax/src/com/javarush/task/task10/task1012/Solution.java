package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
            map.put(alphabet.get(i),0);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        long starttime = System.currentTimeMillis();
        /*for (int i = 0; i < list.size() ; i++) {
            for (int j = 0; j <list.get(i).length() ; j++) {
                if (map.keySet().contains(list.get(i).charAt(j))){
                    map.put(list.get(i).charAt(j), map.get(list.get(i).charAt(j))+1);
                }
            }
        }
        for (Map.Entry p:map.entrySet()) {
            System.out.println(p.getKey()+ " "+p.getValue());
        }
        */
        for(Character ch : alphabet){ //перебрали алфавит
            int count = 0;
            for(String string : list){ //перебрали строки введенные с клавиатуры
                char[] chars = string.toCharArray(); //каждую строку разбираем на массив
                for(char c : chars){ //перебираем массив
                    if(ch == c){
                        count++;
                    }
                }
            }
            System.out.println(ch + " " + count);
        }
        long fifnshtime = System.currentTimeMillis();
        System.out.println(fifnshtime-starttime);

        // напишите тут ваш код
    }

}
