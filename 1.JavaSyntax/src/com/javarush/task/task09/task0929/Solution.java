package com.javarush.task.task09.task0929;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName;
            sourceFileName = reader.readLine();
            sourceFileName = reader.readLine();
        /*try{*/
            String destinationFileName = reader.readLine();
        /*}
        catch (IOException e){
            System.out.println("Файл не существует");
            String destinationFileName = reader.readLine();
        }*/
        InputStream fileInputStream;
        try {
            fileInputStream = getInputStream(sourceFileName);
        }
        catch (IOException e){
                System.out.println("Файл не существует");
                fileInputStream = getInputStream(sourceFileName);

        }
            OutputStream fileOutputStream = getOutputStream(destinationFileName);

            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();

    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

