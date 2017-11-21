package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream reader1 = new FileInputStream(reader.readLine());
        while (reader1.available()>0) {
            System.out.print((char) reader1.read());
        }
        System.out.println();
        reader1.close();
        reader.close();
    }
}

/*
Чтение файла
*/
