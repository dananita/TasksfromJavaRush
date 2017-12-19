package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader =new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        String line;
        while (bufferedReader.ready()){
            line= bufferedReader.readLine();
            Matcher m = Pattern.compile("\\b[0-9]+\\b").matcher(line);
            while (m.find()){
                bufferedWriter.write(m.group()+" ");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
