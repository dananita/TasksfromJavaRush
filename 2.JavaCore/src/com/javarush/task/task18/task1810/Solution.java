package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/data.txt
public class Solution {
    public static void main(String[] args) throws DownloadException {
     while (true) {
         try (FileInputStream file = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
             if (file.getChannel().size() < 1000) {
                 break;
             }
         } catch (IOException e) {
             System.out.println("IOException");
         }
     }
     throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
