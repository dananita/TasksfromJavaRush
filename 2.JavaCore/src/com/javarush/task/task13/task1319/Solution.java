package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader nameFile = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile.readLine()));
        {
            String text;
            while (!(text=reader.readLine()).equals("exit")){
                writer.write(text);
                writer.newLine();
                writer.flush();
            }
            writer.write(text);
            writer.flush();
        }
        writer.close();
        nameFile.close();
        reader.close();
    }
}
