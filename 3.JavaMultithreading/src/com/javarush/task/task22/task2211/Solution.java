package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) {

        // /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/Encoding
        // /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/tempFileEncoding

        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[1])) {
            while (fileInputStream.available() > 0) {
                byte[] buffer = new byte[1024];
                fileInputStream.read(buffer);
                String s = new String(buffer, "UTF-8");
                buffer = s.getBytes("UTF-8");
                fileOutputStream.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
