package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile file = new RandomAccessFile(args[0],"rw")){
            Long position = Long.parseLong(args[1]);
            String text = args[2];
            byte [] buffer = new byte[text.length()];

            file.seek(position);
            file.read(buffer,0,buffer.length);

            String finalTextForFile = new String(buffer).equals(text) ? "true" : "false";
            file.seek(file.length());
            file.write(finalTextForFile.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
