package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Daria Zhuravel
 * @date 22.03.18
 **/
public class ConsoleHelper {
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String text = "";
        try {
            text = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при вводе переменной");
        }
        return text;
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }
}
