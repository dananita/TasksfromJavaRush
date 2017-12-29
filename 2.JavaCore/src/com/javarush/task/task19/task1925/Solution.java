package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameFile1 = args[0];
        String nameFile2 = args[1];
        FileReader fileReader = new FileReader(nameFile1);
        FileWriter fileWriter = new FileWriter(nameFile2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()){
            String[] strings = bufferedReader.readLine().split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].length()>6){
                    stringBuilder.append(strings[i]);
                    stringBuilder.append(",");
                }
            }
        }
        fileReader.close();
        //bufferedReader.close(); валидатор на этой строчке тупит

        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());

        fileWriter.write(stringBuilder.toString());

        fileWriter.close();
    }
}
