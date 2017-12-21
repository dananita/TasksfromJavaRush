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
        int buf = 0;
        int i = 0;

        switch (args[0]) {
            case "-e": {
                while ((tempOneBytes = fileReader.read()) != -1) {
                    buf = tempOneBytes ^ KEY.charAt(i);
                    fileOutputStream.write(buf);
                    i = (i == KEY.length() - 1) ? 0 : i + 1;
                    break;
                }
            }
            case "-d": {
                while ((tempOneBytes = fileReader.read()) != -1) {
                    buf = tempOneBytes ^ KEY.charAt(i);
                    fileOutputStream.write(buf);
                    i = (i == KEY.length() - 1) ? 0 : i + 1;
                }
                break;
            }
        }
        fileReader.close();
        fileOutputStream.close();
    }
}
