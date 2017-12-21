package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    private static String file;
    private static FileOutputStream fileOutputStream;
    private final static String KEY= "aaa";
    private static int smesh = (int)'a'; //смещение алфавита относительно таблицы юникодов
    public static void main(String[] args) throws IOException {
        file = args[1];

        FileInputStream fileReader = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        fileOutputStream = new FileOutputStream(args[2]);

        int tempOneBytes;
        while ((tempOneBytes = fileReader.read()) != -1) {
            stringBuilder.append((char)tempOneBytes);
        }
        fileReader.close();

        switch (args[0]) {
            case "-e":
                encrypt(stringBuilder);
                break;
            case "-d":
                decipher(stringBuilder);
                break;
        }
        fileOutputStream.close();
    }

    public static void encrypt(StringBuilder stringBuilder) throws IOException {

        for (int i = 0; i < stringBuilder.length()-1; i++) {
            int countKey = ((stringBuilder.charAt(i) + KEY.charAt(i % KEY.length()) - 2 * smesh) % 26);
            char c = (char) (countKey + smesh);
            fileOutputStream.write((int) c);
        }

    }
    public static void decipher(StringBuilder stringBuilder) throws IOException {

        for (int i = 0; i < stringBuilder.length()-1; i++) {
            int countKey = ((stringBuilder.charAt(i) - KEY.charAt(i % KEY.length()) + 26) % 26);
            //обратные преобразования с номером буквы в алфавите
            char c = (char) (countKey + smesh);
            fileOutputStream.write((int)c);
        }
    }
}
