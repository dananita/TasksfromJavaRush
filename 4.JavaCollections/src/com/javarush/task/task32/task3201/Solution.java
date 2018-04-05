package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile file = new RandomAccessFile(args[0],"rw")){
            long position = Long.parseLong(args[1]);
            position = (position > file.length()) ? file.length() : position;
            file.seek(position);
            file.write(args[2].getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
