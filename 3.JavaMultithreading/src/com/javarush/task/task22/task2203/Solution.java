package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        String result= "";
            if (string == null || string.isEmpty()) throw new TooShortStringException();
            if (string.split("\\t").length < 3) throw new TooShortStringException();
            String[] massivStringFor4Space = string.split("\\t");
            result = massivStringFor4Space[1];

        return result;

    }

    public static class TooShortStringException extends Exception {
        public TooShortStringException() {
        }
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java."));
    }
}
