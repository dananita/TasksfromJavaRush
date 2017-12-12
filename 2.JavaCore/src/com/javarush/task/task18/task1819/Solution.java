package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;


//  /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/1

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename1);
        byte buffer[] = new byte[fileInputStream.available()];
        fileInputStream.read(buffer,0,fileInputStream.available());
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(filename1);
        fileInputStream = new FileInputStream(filename2);


        Integer tempOneByte = 0;
        while ((tempOneByte=fileInputStream.read())!=-1) {
            fileOutputStream.write(tempOneByte);
        }
        for (int i = 0; i <buffer.length ; i++) {
            fileOutputStream.write(buffer[i]);
        }
         reader.close();
         fileInputStream.close();
         fileOutputStream.close();
    }
}
