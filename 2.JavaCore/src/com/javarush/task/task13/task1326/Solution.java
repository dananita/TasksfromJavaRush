package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        ///media/59A7E55F1637CB7E/JavaRushEx/1.txt
        Scanner word = new Scanner(System.in);
        FileInputStream reader = new FileInputStream (word.nextLine());
        word = new Scanner(reader);
        ArrayList<Integer> list = new ArrayList<>();

        while (word.hasNextLine()){
            int num;
           // System.out.println(word.nextLine());
            num = Integer.parseInt(word.nextLine());
            if (num % 2 ==0) {
                list.add(num);
            }
        }
        word.close();
        reader.close();
        Collections.sort(list);
        for (Integer a:list){
            System.out.println(a);
        }
    }
}
