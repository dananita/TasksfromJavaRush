package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int tempstr=0;
        while (fileReader.ready()){
            tempstr = fileReader.read();
            if (tempstr!=44&&tempstr!=46) fileWriter.write(tempstr);
        }
        fileReader.close();
        fileWriter.close();
    }
}
