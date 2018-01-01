package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example
public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
     static {
         map.put(0,"ноль");
         map.put(1,"один");
         map.put(2,"два");
         map.put(3,"три");
         map.put(4,"четыре");
         map.put(5,"пять");
         map.put(6,"шесть");
         map.put(7,"семь");
         map.put(8,"восемь");
         map.put(9,"девять");
         map.put(10,"десять");
         map.put(11,"одиннадцать");
         map.put(12,"двенадцать");
     }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        reader.close();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            for (int i = 0; i < 13; i++) {
                line = Pattern.compile("\\b(" + i + ")\\b").matcher(line).replaceAll(map.get(i));
            }
            System.out.println(line);
        }
        fileReader.close();
    }
}
