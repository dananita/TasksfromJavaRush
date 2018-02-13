package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;


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
                byte[] buffer = new byte[(int) fileInputStream.getChannel().size()];
                fileInputStream.read(buffer);
                String s = new String(buffer, Charset.forName("Windows-1251"));
                //buffer = s.getBytes("utf8");
                fileOutputStream.write(s.getBytes(Charset.forName("utf-8")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
