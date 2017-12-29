package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        while (reader.ready()){
            Matcher m = Pattern.compile("\\S*\\d+\\S*").matcher(reader.readLine());
            while (m.find()){
                fileWriter.write(m.group()+" ");
            }
        }
        reader.close();
        fileWriter.flush();
        fileWriter.close();
    }
}
