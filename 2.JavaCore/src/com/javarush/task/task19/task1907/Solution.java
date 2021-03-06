package com.javarush.task.task19.task1907;

/* 
Считаем слово world!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        int count = 0;
        String word = "world";
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.toString().split("\\W");
            for (String s : words)
                if (s.equals(word))
                    count++;
        }
        fileReader.close();

        System.out.println(count);
    }
}
