package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.charset.Charset;


// /media/59A7E55F1637CB7E/SQL+GIT+JAVA/Example/
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        FileInputStream file1 = new FileInputStream(filename1);
        FileOutputStream file2 = new FileOutputStream(filename2);

        byte [] buffer = new byte[(int) file1.getChannel().size()];
        file1.read(buffer);
        file1.close();

        String s = new String (buffer);
            for (String retval: s.split(" ")){
            file2.write(Integer.toString(Math.round(Float.parseFloat(retval))).getBytes());
            file2.write(32);
            }
        file2.close();


    }
}
