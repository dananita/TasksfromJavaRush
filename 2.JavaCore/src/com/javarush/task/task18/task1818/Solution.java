package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
    wrapperSystemIn();
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    System.in));
        FileOutputStream file1 = new FileOutputStream(
                reader.readLine());

        FileInputStream file2 = new FileInputStream(
                reader.readLine());
        FileInputStream file3 = new FileInputStream(
                reader.readLine());
        while (file2.available()>0){
            file1.write(file2.read());
        }
        int oneByte;
        while ((oneByte = file3.read())!=-1){
            file1.write(oneByte);
        }
        reader.close();
        file2.close();
        file3.close();
        file1.close();
    }

    public static void wrapperSystemIn(){
        StringBuilder builder = new StringBuilder();
        builder
                .append("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/data.txt")
                .append('\n');
        builder
                .append("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/result.txt")
                .append('\n');
        builder
                .append("/media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/result1.txt")
                .append('\n');

        System.setIn(new ByteArrayInputStream(builder.toString().getBytes()));

    }
}
