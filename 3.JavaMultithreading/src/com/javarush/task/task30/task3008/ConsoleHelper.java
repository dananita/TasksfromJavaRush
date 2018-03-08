package com.javarush.task.task30.task3008;

/**
 * @author Daria Zhuravel
 * @date 09.03.18
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * вспомогательный класс, для чтения или записи в консоль.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    /**
     * Выводит message на консоль
     * @param message
     */
    public static void writeMessage( String message){
        System.out.println(message);
    }

    public static String readString(){
        String result = null;
        while(true) {
            try {
                result = bufferedReader.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return result;
    }
    public static int readInt(){
        int result = 0;
        while(true) {
            try {
                result = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return result;
    }


}
