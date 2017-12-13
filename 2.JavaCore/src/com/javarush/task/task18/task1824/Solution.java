package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String namefile = "";
        while (true) {
            try {
                namefile = reader.readLine();
                (new FileInputStream(new File(namefile))).close();
            } catch (FileNotFoundException ex) {
                try {
                    reader.close();
                } catch (IOException e) {
                    /* NOP */
                }
                System.out.println(namefile);
                break;
            } catch (IOException e) {
                /* NOP */
            }
        }
    }
}
