package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(reader.readLine());
        BufferedReader br = new BufferedReader(file1);

        // id productName price quantity
        String line = "";
        while (br.ready()) {
            line = br.readLine();
            if (line.startsWith(args[0] + " ")) {
                System.out.println(line);
                break;
            }

        }

        br.close();
        file1.close();
        reader.close();
    }
}
