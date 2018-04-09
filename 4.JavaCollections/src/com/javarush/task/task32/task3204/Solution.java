package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream(8);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        while(true) {
            String pwd = "";
            for (int i = 0; i < 8; i++) {
                pwd += characters.charAt((int) (Math.random() * characters.length()));
            }
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";
            if (pwd.matches(pattern)) {
                stream.write(pwd.getBytes());
                break;
            }
        }
        return stream;
    }
}